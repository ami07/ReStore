/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pig.backend.hadoop.executionengine.physicalLayer.plans;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.hadoop.conf.Configuration;
import org.apache.pig.FuncSpec;
import org.apache.pig.data.Tuple;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.PhysicalOperator;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.expressionOperators.BinaryExpressionOperator;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.expressionOperators.ExpressionOperator;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.expressionOperators.POBinCond;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.expressionOperators.UnaryComparisonOperator;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POFRJoin;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POFilter;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POForEach;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POJoinPackage;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POLoad;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POMergeCogroup;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POMergeJoin;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POMultiQueryPackage;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POPackage;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POPackageLite;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POStore;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POUnion;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.util.PlanHelper;
import org.apache.pig.impl.PigContext;
import org.apache.pig.impl.io.FileSpec;
import org.apache.pig.impl.io.InterStorage;
import org.apache.pig.impl.plan.NodeIdGenerator;
import org.apache.pig.impl.plan.OperatorKey;
import org.apache.pig.impl.plan.OperatorPlan;
import org.apache.pig.impl.plan.PlanException;
import org.apache.pig.impl.plan.VisitorException;
import org.apache.pig.impl.util.MultiMap;
import org.apache.pig.impl.util.Pair;

/**
 * 
 * The base class for all types of physical plans. 
 * This extends the Operator Plan.
 *
 */
public class PhysicalPlan extends OperatorPlan<PhysicalOperator> implements Cloneable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

	private static final String DISCOVER_NEWPLANS_HEURISTICS = "sharing.useHeuristics.discoverPlans";

	private static final String DISCOVER_NEWPLANS_HEURISTICS_INNER = "sharing.useHeuristics.discoverPlans.inner";

	private static final String TEMP_FILE = "tempOutput";

	private static final String SHARED_FILE = "SharedMROutput";

	private static final String RESTORE_DISCOVER_HEURISTIC_AGG = "HA";

	private static final String RESTORE_DISCOVER_HEURISTIC_CONS = "HC";
    
    // marker to indicate whether all input for this plan
    // has been sent - this is currently only used in POStream
    // to know if all map() calls and reduce() calls are finished
    // and that there is no more input expected.
    public boolean endOfAllInput = false;

    private MultiMap<PhysicalOperator, PhysicalOperator> opmap = null;

	private int tmpFileIter;
    
    public PhysicalPlan() {
        super();
    }
    
    public void attachInput(Tuple t){
        List<PhysicalOperator> roots = getRoots();
        for (PhysicalOperator operator : roots) {
            operator.attachInput(t);
		}
    }
    
    public void detachInput(){
        for(PhysicalOperator op : getRoots())
            op.detachInput();
    }
    /**
     * Write a visual representation of the Physical Plan
     * into the given output stream
     * @param out : OutputStream to which the visual representation is written
     */
    public void explain(OutputStream out) {
        explain(out, true);
    }

    /**
     * Write a visual representation of the Physical Plan
     * into the given output stream
     * @param out : OutputStream to which the visual representation is written
     * @param verbose : Amount of information to print
     */
    public void explain(OutputStream out, boolean verbose){
        PlanPrinter<PhysicalOperator, PhysicalPlan> mpp = new PlanPrinter<PhysicalOperator, PhysicalPlan>(
                this);
        mpp.setVerbose(verbose);

        try {
            mpp.print(out);
        } catch (VisitorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Write a visual representation of the Physical Plan
     * into the given printstream
     * @param ps : PrintStream to which the visual representation is written
     * @param format : Format to print in
     * @param verbose : Amount of information to print
     */
    public void explain(PrintStream ps, String format, boolean verbose) {
        ps.println("#-----------------------------------------------");
        ps.println("# Physical Plan:");
        ps.println("#-----------------------------------------------");

        if (format.equals("text")) {
            explain((OutputStream)ps, verbose);
            ps.println("");
        } else if (format.equals("dot")) {
            DotPOPrinter pp = new DotPOPrinter(this, ps);
            pp.setVerbose(verbose);
            pp.dump();
        }
        ps.println("");
  }
    
    @Override
    public void connect(PhysicalOperator from, PhysicalOperator to)
            throws PlanException {
        
        super.connect(from, to);
        to.setInputs(getPredecessors(to));
    }
    
    /*public void connect(List<PhysicalOperator> from, PhysicalOperator to) throws IOException{
        if(!to.supportsMultipleInputs()){
            throw new IOException("Invalid Operation on " + to.name() + ". It doesn't support multiple inputs.");
        }
        
    }*/
    
    @Override
    public void remove(PhysicalOperator op) {
        op.setInputs(null);
        List<PhysicalOperator> sucs = getSuccessors(op);
        if(sucs!=null && sucs.size()!=0){
            for (PhysicalOperator suc : sucs) {
                // successor could have multiple inputs
                // for example = POUnion - remove op from
                // its list of inputs - if after removal
                // there are no other inputs, set successor's
                // inputs to null
                List<PhysicalOperator> succInputs = suc.getInputs();
                succInputs.remove(op);
                if(succInputs.size() == 0)
                    suc.setInputs(null);
                else
                    suc.setInputs(succInputs);
            }
        }
        super.remove(op);
    }
    
    /* (non-Javadoc)
     * @see org.apache.pig.impl.plan.OperatorPlan#replace(org.apache.pig.impl.plan.Operator, org.apache.pig.impl.plan.Operator)
     */
    @Override
    public void replace(PhysicalOperator oldNode, PhysicalOperator newNode)
            throws PlanException {
        List<PhysicalOperator> oldNodeSuccessors = getSuccessors(oldNode);
        super.replace(oldNode, newNode);
        if(oldNodeSuccessors != null) {
            for (PhysicalOperator preds : oldNodeSuccessors) {
                List<PhysicalOperator> inputs = preds.getInputs();
                // now replace oldNode with newNode in
                // the input list of oldNode's successors
                for(int i = 0; i < inputs.size(); i++) {
                    if(inputs.get(i) == oldNode) {
                        inputs.set(i, newNode);
                    }
                }    
            }
        }
        
    }
    
    /* (non-Javadoc)
     * @see org.apache.pig.impl.plan.OperatorPlan#replace(org.apache.pig.impl.plan.Operator, List<org.apache.pig.impl.plan.Operator>)
     */
    @Override
    public void replace(PhysicalOperator oldNode, List<PhysicalOperator> newNodes) throws PlanException {
    	List<PhysicalOperator> oldNodeSuccessors = getSuccessors(oldNode);
    	super.replace(oldNode, newNodes);
    	
    	if(oldNodeSuccessors != null) {
            for (PhysicalOperator preds : oldNodeSuccessors) {
                List<PhysicalOperator> inputs = preds.getInputs();
                // now replace oldNode with newNode in
                // the input list of oldNode's successors
                if(inputs.remove(oldNode)){
	                //add the new succs as input
	                for(PhysicalOperator newNode:newNodes){
	                	inputs.add(newNode);
	                }
                } 
            }
        }
	}

    /* (non-Javadoc)
     * @see org.apache.pig.impl.plan.OperatorPlan#replaceWithExisting(org.apache.pig.impl.plan.Operator, org.apache.pig.impl.plan.Operator)
     */
    @Override
    public void replaceWithExisting(PhysicalOperator oldNode, PhysicalOperator newNode)
            throws PlanException {
        List<PhysicalOperator> oldNodeSuccessors = getSuccessors(oldNode);
        super.replaceWithExisting(oldNode, newNode);
        if(oldNodeSuccessors != null) {
            for (PhysicalOperator preds : oldNodeSuccessors) {
                List<PhysicalOperator> inputs = preds.getInputs();
                // now replace oldNode with newNode in
                // the input list of oldNode's successors
                for(int i = 0; i < inputs.size(); i++) {
                    if(inputs.get(i) == oldNode) {
                    	if(!inputs.contains(newNode)){
                    		inputs.set(i, newNode);
                    	}
                    }
                }
                inputs.remove(oldNode);
            }
        }
        
    }
    
    /* (non-Javadoc)
     * @see org.apache.pig.impl.plan.OperatorPlan#add(org.apache.pig.impl.plan.Operator)
    @Override
    public void add(PhysicalOperator op) {
        // attach this plan as the plan the operator is part of
        //op.setParentPlan(this);
        super.add(op);
    }
*/

    public boolean isEmpty() {
        return (mOps.size() == 0);
    }

    @Override
    public String toString() {
        if(isEmpty())
            return "Empty Plan!";
        else{
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            explain(baos, true);
            return baos.toString();
        }
    }

    @Override
    public PhysicalPlan clone() throws CloneNotSupportedException {
        PhysicalPlan clone = new PhysicalPlan();

        // Get all the nodes in this plan, and clone them.  As we make
        // clones, create a map between clone and original.  Then walk the
        // connections in this plan and create equivalent connections in the
        // clone.
        Map<PhysicalOperator, PhysicalOperator> matches = 
            new HashMap<PhysicalOperator, PhysicalOperator>(mOps.size());
        for (PhysicalOperator op : mOps.keySet()) {
            PhysicalOperator c = op.clone();
            clone.add(c);
            if (opmap != null)
                opmap.put(op, c);
            matches.put(op, c);
        }

        // Build the edges
        for (PhysicalOperator op : mFromEdges.keySet()) {
            PhysicalOperator cloneFrom = matches.get(op);
            if (cloneFrom == null) {
                String msg = "Unable to find clone for op " + op.name();
                throw new CloneNotSupportedException(msg);
            }
            Collection<PhysicalOperator> toOps = mFromEdges.get(op);
            for (PhysicalOperator toOp : toOps) {
                PhysicalOperator cloneTo = matches.get(toOp);
                if (cloneTo == null) {
                    String msg = "Unable to find clone for op " + toOp.name();
                    throw new CloneNotSupportedException(msg);
                }
                try {
                    clone.connect(cloneFrom, cloneTo);
                } catch (PlanException pe) {
                    CloneNotSupportedException cnse = new CloneNotSupportedException();
                    cnse.initCause(pe);
                    throw cnse;
                }
            }
        }

        // Fix up all the inputs in the operators themselves.
        for (PhysicalOperator op : mOps.keySet()) {
            List<PhysicalOperator> inputs = op.getInputs();
            if (inputs == null || inputs.size() == 0) continue;
            List<PhysicalOperator> newInputs = 
                new ArrayList<PhysicalOperator>(inputs.size());
            PhysicalOperator cloneOp = matches.get(op);
            if (cloneOp == null) {
                String msg = "Unable to find clone for op " + op.name();
                throw new CloneNotSupportedException(msg);
            }
            for (PhysicalOperator iOp : inputs) {
            	if(mOps.containsKey(iOp)){//the below code is only executed when iOp is in the mOps.keyset
	                PhysicalOperator cloneIOp = matches.get(iOp);
	                if (cloneIOp == null) {
	                    String msg = "Unable to find clone for op " + iOp.name();
	                    throw new CloneNotSupportedException(msg);
	                }
	                newInputs.add(cloneIOp);
            	}else{
            		//to fix the case of an input that is not in the mOps.keyset
            		PhysicalOperator cloneIOp = iOp.clone();
            		newInputs.add(cloneIOp);
            	}
            }
            cloneOp.setInputs(newInputs);
        }
        
        for (PhysicalOperator op : mOps.keySet()) {
            if (op instanceof UnaryComparisonOperator) {
                UnaryComparisonOperator orig = (UnaryComparisonOperator)op;
                UnaryComparisonOperator cloneOp = (UnaryComparisonOperator)matches.get(op);
                cloneOp.setExpr((ExpressionOperator)matches.get(orig.getExpr()));
                cloneOp.setOperandType(orig.getOperandType());
            } else if (op instanceof BinaryExpressionOperator) {
                BinaryExpressionOperator orig = (BinaryExpressionOperator)op;
                BinaryExpressionOperator cloneOp = (BinaryExpressionOperator)matches.get(op);
                cloneOp.setRhs((ExpressionOperator)matches.get(orig.getRhs()));
                cloneOp.setLhs((ExpressionOperator)matches.get(orig.getLhs()));
            } else if (op instanceof POBinCond) {
                POBinCond orig = (POBinCond)op;
                POBinCond cloneOp = (POBinCond)matches.get(op);
                cloneOp.setRhs((ExpressionOperator)matches.get(orig.getRhs()));
                cloneOp.setLhs((ExpressionOperator)matches.get(orig.getLhs()));
                cloneOp.setCond((ExpressionOperator)matches.get(orig.getCond()));
            }
        }

        return clone;
    }
    
    
	
    public void setOpMap(MultiMap<PhysicalOperator, PhysicalOperator> opmap) {
        this.opmap = opmap;
    }
    
    public void resetOpMap()
    {
        opmap = null;
    }
    
    /**
	 * Checks if otherPlan is equivalent to this plan
     * @throws VisitorException 
	 */
	public boolean isEquivalent(PhysicalPlan otherPlan) {
		if(otherPlan instanceof PhysicalPlan){
			//the other operator is also an PhysicalPlan then there is a possibility of equivalence
			
			PhyPlanComparator planComparator = new PhyPlanComparator(this,otherPlan);
			try {
				return planComparator.visit(otherPlan);
			} catch (VisitorException e) {
				e.setDetailedMessage("Error while trying to check plan equivalence: "+e.getMessage());
				e.printStackTrace();
				return false;
			}
			
		}
		return false;
	}
	
	/**
	 * 
	 * @param otherPlan to check its matching with the current plan and see possibility for replacing part of it
	 * @return the last matched operators in this and other plans, null if the two plans could not be matched
	 * @throws VisitorException
	 */
	public PhysicalOperator getPlanRecplacedWithView(PhysicalPlan otherPlan) throws VisitorException {
		if(otherPlan instanceof PhysicalPlan){
			PhyPlanReplacer planReplacer = new PhyPlanReplacer(this,otherPlan);
			PhysicalOperator matchedOperator = planReplacer.visit(otherPlan,true);
			if(matchedOperator!=null){
				System.out.println("Last operator before plans got matched is "+matchedOperator);
				return matchedOperator;
			}else{
				System.out.println("Could not match the plans");
				return null;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param oldOperator an operator in the current plant to be replaced with a load operator
	 * @param poStore the store operator that has the temp information to be copied into a load operator
	 * @param pigContext
	 * @throws PlanException
	 */
	public void replaceOperatorWithLoad(PhysicalOperator oldOperator,
			POStore poStore,PigContext pigContext) throws PlanException {
		//create a new load from the store file
		String scope = poStore.getOperatorKey().scope;
		NodeIdGenerator nodeGen = NodeIdGenerator.getGenerator();
		
		FileSpec lFile=poStore.getInputSpec();
		POLoad load = new POLoad(new OperatorKey(scope, nodeGen
                .getNextNodeId(scope)), lFile);
        load.setLFile(poStore.getSFile());
        load.setPc(pigContext);
        load.setResultType(poStore.getResultType());
        
        
        //replace the plan rooted with oldOperator with the new load
        //FIRST: remove the inputs of the oldOperator and remove all the predecessor nodes of the oldOperator
        //oldOperator.setInputs(null);
        //remove the predecessor nodes
        List<PhysicalOperator> oldNodePredecessors = getPredecessors(oldOperator);
        while(oldNodePredecessors!=null && !oldNodePredecessors.isEmpty()){
        	PhysicalOperator oldPred=oldNodePredecessors.get(0);
        	//remove predecessor from plan
        	remove(oldPred);
        }
        
        String aliasOfLastOpToShare=oldOperator.getAlias();
		if(aliasOfLastOpToShare!=null){
			load.addOriginalLocation(aliasOfLastOpToShare, poStore.getOriginalLocations());
		}
		
        //SECOND: replace the operators
        replace(oldOperator,load);
	}
	
	/**
	 * This method parses the plan from its load operators and injects Store operators after the operators in the plan
	 * that we care about reserving their output
	 * @param pigContext
	 * @param conf
	 * @param stores the store operators for this plan
	 * @param newMapperRootPlans the new MR plan pairs that are created due to the injection of new store operator in the paln 
	 * @return the physical plans that we are interested in storing their output
	 * @throws PlanException
	 * @throws VisitorException
	 * @throws CloneNotSupportedException
	 */
	public Vector<PhysicalPlan> discoverUsefulSubplans(PigContext pigContext, Configuration conf,List<POStore> stores, List <Pair<PhysicalPlan, PhysicalPlan>> newMapperRootPlans) throws PlanException, VisitorException, CloneNotSupportedException {
		
		boolean isUseDiscovePlanHeuristics=conf.getBoolean(DISCOVER_NEWPLANS_HEURISTICS, false);
		boolean isUseDiscovePlanHeuristicsInner=conf.getBoolean(DISCOVER_NEWPLANS_HEURISTICS_INNER, false);
		
		Vector<PhysicalPlan> discoveredPlans=new Vector<PhysicalPlan>();
		
		//find loads of this plan
		List<POLoad> planLoads = PlanHelper.getPhysicalOperators(this, POLoad.class);
		
		if(planLoads==null || planLoads.isEmpty()){
			//no loads in this plan
			return discoveredPlans;
		}
		
		//for every found load, copy the plan until a filter, or foreach is reached
		for(POLoad load:planLoads){
			//get the successors of the load
			List<PhysicalOperator> loadSucc=this.getSuccessors(load);
			if(loadSucc!= null && !loadSucc.isEmpty()){
				List<PhysicalOperator> loadSuccCopy=new ArrayList<PhysicalOperator>(loadSucc);
				//for every successor, check to find a filter or for each
				for(PhysicalOperator succ:loadSuccCopy){
					
					if(isUseDiscovePlanHeuristics){
						//check if the succ is a filter or foreach
						if((succ instanceof POFilter || succ instanceof POForEach) && ! PhysicalPlan.hasStoreSuccessor(succ,this)){
							//this is the subplan that we are looking for
							//STEP1:split the plan by adding a store after this filter/foreach op , then create two other plans
							List<PhysicalOperator> opSuccs = this.getSuccessors(succ); 
							
							PhysicalPlan sharedOperatorsPlan=null;
							if(opSuccs==null || opSuccs.size()==0){
								//sharedOperatorsPlan=duplicateLastMapperOp(succ, pigContext,stores);
							}else{
								 sharedOperatorsPlan=splitPlan(load, succ, pigContext,stores,planLoads, newMapperRootPlans);
							}
							
							
							//STEP2:add the cloned plan to the list of discovered plans
							if(sharedOperatorsPlan!=null){
								discoveredPlans.add(sharedOperatorsPlan);
							}
						}//end if instance of pofilter or poforeach
					}else{
						//allow inserting store after all operators, except for the load and store operators and operators wit a successor parent
						
						if(! (succ instanceof POLoad) && ! (succ instanceof POStore)  && ! PhysicalPlan.hasStoreSuccessor(succ,this)){
							
							if(isUseDiscovePlanHeuristicsInner){
								if((succ instanceof POFilter || succ instanceof POForEach) && !  PhysicalPlan.hasStoreSuccessor(succ,this)){
									//STEP1:split the plan by adding a store after this filter/foreach op , then create two other plans
									PhysicalPlan sharedOperatorsPlan=null;
									List<PhysicalOperator> opSuccs = this.getSuccessors(succ); 
									if(opSuccs==null || opSuccs.size()==0){
										//sharedOperatorsPlan=duplicateLastMapperOp(succ, pigContext,stores,newMapperRootPlans);
									}else{
										sharedOperatorsPlan=splitPlan(load, succ, pigContext,stores, planLoads, newMapperRootPlans);
									}
									//STEP2:add the cloned plan to the list of discovered plans
									if(sharedOperatorsPlan!=null){
										discoveredPlans.add(sharedOperatorsPlan);
									}
								}
							}else{
								//STEP1:split the plan by adding a store after this filter/foreach op , then create two other plans
								PhysicalPlan sharedOperatorsPlan=null;
								List<PhysicalOperator> opSuccs = this.getSuccessors(succ); 
								if(opSuccs==null || opSuccs.size()==0){
									//sharedOperatorsPlan=duplicateLastMapperOp(succ, pigContext,stores,newMapperRootPlans);
								}else{
									sharedOperatorsPlan=splitPlan(load, succ, pigContext,stores, planLoads, newMapperRootPlans);
								}
								//STEP2:add the cloned plan to the list of discovered plans
								if(sharedOperatorsPlan!=null){
									discoveredPlans.add(sharedOperatorsPlan);
								}
							}
						}
						
					}
				}//end for
			}//end if loadsucc is valid
		}
		return discoveredPlans;
	}

	/**
	 * 
	 * This function checks if an operator has immediate successors that are a store operator
	 * @param op the operator that we will check if its successors are store opertaors
	 * @param plan the plan to check op successors in it
	 * @return true if op has store successors in plan
	 */
	private static boolean hasStoreSuccessor(PhysicalOperator op, PhysicalPlan plan) {
		List<PhysicalOperator> opSuccs = plan.getSuccessors(op); 
		if(opSuccs==null || opSuccs.size()==0){
			return false;
		}
		for(PhysicalOperator succ:opSuccs){
			if(succ instanceof POStore){
				return true;
			}
		}
	
		return false;
	}
	
	/**
	 * Split the plan into two plans before and after the lastOpToShare
	 * @param load the load operator which has lastOpToShare as a decendent 
	 * @param lastOpToShare the operator to split the plan around it
	 * @param pigContext
	 * @param stores the stores of this plan to use when creating the new physical plan
	 * @param planLoads the loads of this plan to use when creating the new physical plan 
	 * @param newMapperRootPlans a structure to return the newly created plans
	 * @return the sub-plan before the lastOpToShare, this plan is the one that will be a candidate for sharing
	 * @throws PlanException
	 * @throws CloneNotSupportedException
	 * @throws VisitorException
	 */
	private PhysicalPlan splitPlan(POLoad load, PhysicalOperator lastOpToShare, PigContext pigContext,
			List<POStore> stores, List<POLoad> planLoads, List<Pair<PhysicalPlan, PhysicalPlan>> newMapperRootPlans) throws PlanException, CloneNotSupportedException, VisitorException {
		
		//initialize a pair to include the two created plans
		Pair<PhysicalPlan, PhysicalPlan> newMapperRootPlansPair = new Pair<PhysicalPlan,PhysicalPlan>(null, null);
		
		//get successors of the lastOpToShare
		List<PhysicalOperator> succsItr=getSuccessors(lastOpToShare);
		List<PhysicalOperator> succs=new ArrayList<PhysicalOperator>();
		if(succsItr!=null){
			succs.addAll(succsItr);
		}
		
		List<POLoad> lastOpToShareDecLoads=new ArrayList<POLoad> ();
		lastOpToShareDecLoads.add(load);
		for(POLoad planLoad:planLoads){
			if(!load.equals(planLoad) && isAncetorNode(planLoad, lastOpToShare)){
				lastOpToShareDecLoads.add(planLoad);
			}
		}
		
		//PLAN: shared mapper
		//copy the operators from load till this operator into a new plan, return the plan
		PhysicalPlan sharedOperatorsPlan= createPlanFromLoadToOperator(lastOpToShareDecLoads, lastOpToShare);
		//add a store operator to that plan
		String scope = lastOpToShare.getOperatorKey().scope;
		NodeIdGenerator nodeGen = NodeIdGenerator.getGenerator();
		
		FuncSpec funcSpec=new FuncSpec(InterStorage.class.getName());
		POStore store = new POStore(new OperatorKey(scope, nodeGen.getNextNodeId(scope)));
		store.addOriginalLocation(lastOpToShare.getAlias(),lastOpToShare.getOriginalLocations());
		store.setSFile(new FileSpec(TEMP_FILE+tmpFileIter+System.currentTimeMillis(), funcSpec));
		tmpFileIter++;
		if(stores!=null && !stores.isEmpty()){
			store.setInputSpec(stores.get(0).getInputSpec());
		}
        
        store.setIsTmpStore(true);
        sharedOperatorsPlan.addAsLeaf(store);
		//add the new plan to root plans
		newMapperRootPlansPair.first=sharedOperatorsPlan;
		
		//PLAN: unshared operators in this mapper
		//create a load to read from the tmp file
		NodeIdGenerator nodeGenLoad = NodeIdGenerator.getGenerator();
		
		FileSpec lFile=store.getInputSpec();
		POLoad tmpLoad = new POLoad(new OperatorKey(scope, nodeGenLoad
                .getNextNodeId(scope)), lFile);
		tmpLoad.setLFile(store.getSFile());
		tmpLoad.setPc(pigContext);
		tmpLoad.setResultType(store.getResultType());
		String aliasOfLastOpToShare=lastOpToShare.getAlias();
		if(aliasOfLastOpToShare!=null){
			tmpLoad.addOriginalLocation(aliasOfLastOpToShare,store.getOriginalLocations());
		}
		
		this.replace(lastOpToShare, tmpLoad);
		
		
			
		//create a load store plan
		PhysicalPlan loadStorePlan = createLoadStorePlan(store,pigContext);
		//add the load store plan to the new root plans
		newMapperRootPlansPair.second=loadStorePlan;
		
		newMapperRootPlans.add(newMapperRootPlansPair);
		
		//create a clone of sharedOperatorsPlan and replace the store to be the sharedStore location from the loadStorePlan
		PhysicalPlan sharedOperatorsPlanClone = sharedOperatorsPlan.clone();
		POStore storeFromLoadStorePlan = (POStore) PlanHelper.getPhysicalOperators(loadStorePlan, POStore.class).get(0).clone();
		POStore currentStore = PlanHelper.getPhysicalOperators(sharedOperatorsPlanClone, POStore.class).get(0);
		sharedOperatorsPlanClone.replace(currentStore, storeFromLoadStorePlan);
		
		return sharedOperatorsPlanClone;
	}
	
	/**
	 * Checks if ansOperator is an ancestor of operator in the current plan
	 * @param ansOperator
	 * @param operator
	 * @return true if ansOperator is an ancestor of operator
	 */
	private boolean isAncetorNode(PhysicalOperator ansOperator,
			PhysicalOperator operator) {
		if(ansOperator.equals(operator)){
			return true;
		}
		List<PhysicalOperator> preds=this.getPredecessors(operator);
		if(preds==null || preds.isEmpty()){
			return false;
		}else{
			for(PhysicalOperator pred:preds){
				if(isAncetorNode(ansOperator, pred)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Used when splitting a plan around operator. This helper function will create a new plan starting from 
	 * load operators (roots of the plan) to the operator I am splitting the plan around. 
	 * @param loads the load operators that are ancestors of the lastOpToShare
	 * @param lastOpToShare The operator I am creating a new plan from it after ignoring all its predecessors
	 * @return the new plan that is created
	 * @throws PlanException
	 * @throws CloneNotSupportedException
	 */
	private PhysicalPlan createPlanFromLoadToOperator(List<POLoad> loads,
			PhysicalOperator lastOpToShare) throws PlanException, CloneNotSupportedException {
		PhysicalPlan newPlan=new PhysicalPlan();
		List<PhysicalOperator> lastOpToShareClone = new ArrayList<PhysicalOperator>();
		moveOperatorAndSuccToPlan(loads.get(0),lastOpToShare, newPlan, lastOpToShareClone);
		for(int i=1;i<loads.size();i++){
			moveOperatorAndSuccToPlan(loads.get(i),lastOpToShare, newPlan, lastOpToShareClone);
		}
		return newPlan;
	}
	
	/**
	 * Given a plan, this helper function recursively moves an operator and all of its successors to a plan 
	 * @param operator
	 * @param lastOpToShare
	 * @param newPlan
	 * @param lastOperatorClone
	 * @return
	 * @throws PlanException
	 * @throws CloneNotSupportedException
	 */
	private PhysicalOperator moveOperatorAndSuccToPlan(PhysicalOperator operator, PhysicalOperator lastOpToShare, PhysicalPlan newPlan, List<PhysicalOperator> lastOperatorClone) throws PlanException, CloneNotSupportedException {
		//add operator to new plan
		PhysicalOperator operatorClone=null;
		
		
		if(operator.equals(lastOpToShare)){
			//remove operator from this plan
			//this.remove(operator);
			if(lastOperatorClone.isEmpty()){
				operatorClone=operator.clone();
				newPlan.add(operatorClone);
				lastOperatorClone.add(operatorClone);
			}else{
				operatorClone=lastOperatorClone.get(0);
			}
			return operatorClone;
		}else{
			operatorClone=operator.clone();
			newPlan.add(operatorClone);
			
		}
		//get successors of the operator
		List<PhysicalOperator> succs=getSuccessors(operator);
		//move every succ and its succs into the new plan and then copy their connections as well
		if(succs!=null){
			List<PhysicalOperator> succsCopy=new ArrayList<PhysicalOperator>(succs);
			for(PhysicalOperator succ:succsCopy){
				//move operator and its successors to plan
				PhysicalOperator succClone=moveOperatorAndSuccToPlan(succ,lastOpToShare, newPlan, lastOperatorClone);
				//move connections between op and succ to new plan
				newPlan.connect(operatorClone,  succClone);		
			}
		}
		//remove operator from this plan
		this.remove(operator);
		
		return operatorClone;
	}
	
	/**
	 * Given a store operator create a new plan that has a load from its storage location and stores the data in 
	 * a shared storage
	 * @param tmpStore the store operator that we will use its storage location information to create the load operator
	 * in the newly created plan
	 * @param pigContext
	 * @return the new plan that we create
	 * @throws PlanException
	 */
	private PhysicalPlan createLoadStorePlan(POStore tmpStore, PigContext pigContext) throws PlanException{
		PhysicalPlan newLoadStorePlan=new PhysicalPlan();
		
		String scope = tmpStore.getOperatorKey().scope;
		
		
		//create a load that reads from this tmp Store
		NodeIdGenerator nodeGenLoad = NodeIdGenerator.getGenerator();
		FileSpec lFile=tmpStore.getInputSpec();
		POLoad tmpLoad = new POLoad(new OperatorKey(scope, nodeGenLoad
                .getNextNodeId(scope)), lFile);
		tmpLoad.setLFile(tmpStore.getSFile());
		tmpLoad.setPc(pigContext);
		tmpLoad.setResultType(tmpStore.getResultType());
		String aliasOfLastOpToShare=tmpStore.getAlias();
		if(aliasOfLastOpToShare!=null){
			tmpLoad.addOriginalLocation(aliasOfLastOpToShare,tmpStore.getOriginalLocations());
		}
		
		newLoadStorePlan.add(tmpLoad);
		
		//create a store that stores the data into a perm shared location
		NodeIdGenerator nodeGenStore = NodeIdGenerator.getGenerator();
		POStore shareStore = new POStore(new OperatorKey(scope, nodeGenStore.getNextNodeId(scope)));
		shareStore.addOriginalLocation(tmpStore.getAlias(),tmpStore.getOriginalLocations());
		shareStore.setSFile(new FileSpec(SHARED_FILE+tmpFileIter+System.currentTimeMillis(), tmpStore.getSFile().getFuncSpec()));
		tmpFileIter++;
		//shareStore.setInputSpec(tmpStore.getInputSpec());
		
        
		shareStore.setIsTmpStore(false);
        newLoadStorePlan.addAsLeaf(shareStore);
        
		//connect the load/Store operators
        //newLoadStorePlan.connect(tmpLoad, shareStore);
		return newLoadStorePlan;
	}
	
	/**
	 * Injects Store operators in the reducer plan
	 * @param pigContext
	 * @param conf
	 * @param stores the Store operators in this Reduce plan
	 * @param newMapperRootPlans The new plans created due to injecting Store operators
	 * @throws PlanException
	 * @throws CloneNotSupportedException
	 */
	public void discoverUsefulSubplansReducer(PigContext pigContext,
			Configuration conf, List<POStore> stores,
			List<PhysicalPlan> newMapperRootPlans) throws PlanException, CloneNotSupportedException {
		
		//find the roots of this plan
		List<PhysicalOperator> roots = new ArrayList<PhysicalOperator>(this.getRoots());
		for(PhysicalOperator op: roots){
			//insert a store after this operator
			if(! (op instanceof POLoad) && ! (op instanceof POStore)  && ! PhysicalPlan.hasStoreSuccessor(op,this)){
				splitReducerPlan(op, newMapperRootPlans, pigContext, stores);
			}
		}
		
	}
	
	/**
	 * Used to split a plan given an operator. The plan is split to operators before that operastor op and operators from loads
	 * to that operator op
	 * @param op The operator to split the plan around
	 * @param newMapperRootPlans The new split plans 
	 * @param pigContext
	 * @param stores the store operators of that plan
	 * @throws PlanException
	 * @throws CloneNotSupportedException
	 */
	private void splitReducerPlan(PhysicalOperator op,
			List<PhysicalPlan> newMapperRootPlans,PigContext pigContext, List<POStore> stores ) throws PlanException, CloneNotSupportedException {
		//create a new store
		String scope = op.getOperatorKey().scope;
		NodeIdGenerator nodeGen = NodeIdGenerator.getGenerator();
		//List<POStore> stores = PlanHelper.getStores(this);
		
		FuncSpec funcSpec=new FuncSpec(InterStorage.class.getName());
		POStore store = new POStore(new OperatorKey(scope, nodeGen.getNextNodeId(scope)));
		store.addOriginalLocation(op.getAlias(),op.getOriginalLocations());
		store.setSFile(new FileSpec(SHARED_FILE+tmpFileIter+System.currentTimeMillis(), funcSpec));
		tmpFileIter++;
		if(stores!=null && !stores.isEmpty()){
			store.setInputSpec(stores.get(0).getInputSpec());
		}
		
		//for each succ of op, create a new plan
		List<PhysicalOperator> succs=getSuccessors(op);
		if(succs!=null){
			List<PhysicalOperator> succCopy=new ArrayList<PhysicalOperator>(succs);
			for(PhysicalOperator succ:succCopy){
				PhysicalPlan newPlan=new PhysicalPlan();
				PhysicalOperator succClone = moveOpsFromLastSharedToLeaf(succ,newPlan);
				//create load and add it to plan
				NodeIdGenerator nodeGenLoad = NodeIdGenerator.getGenerator();
				
				FileSpec lFile=store.getInputSpec();
				POLoad tmpLoad = new POLoad(new OperatorKey(scope, nodeGenLoad
		                .getNextNodeId(scope)), lFile);
				tmpLoad.setLFile(store.getSFile());
				tmpLoad.setPc(pigContext);
				tmpLoad.setResultType(store.getResultType());
				String aliasOfLastOpToShare=op.getAlias();
				if(aliasOfLastOpToShare!=null){
					tmpLoad.addOriginalLocation(aliasOfLastOpToShare,op.getOriginalLocations());
				}
				newPlan.add(tmpLoad);
				newPlan.connect(tmpLoad, succClone);
				newMapperRootPlans.add(newPlan);
			}
		}
		
		//add store to this plan
		this.addAsLeaf(store);
		
	}
	
	/**
	 * A helper function used to split a plan around operator
	 * @param operator The operator to split the plan around
	 * @param newPlan The new plan to update with the operators
	 * @return the last operator to be moved from this plan to the new created plan
	 * @throws CloneNotSupportedException
	 * @throws PlanException
	 */
	private PhysicalOperator moveOpsFromLastSharedToLeaf(PhysicalOperator operator, PhysicalPlan newPlan) throws CloneNotSupportedException, PlanException {
		
		if(operator==null){
			return null;
		}
		PhysicalOperator operatorClone=null;
		operatorClone=operator.clone();
		newPlan.add(operatorClone);
		
		//get successors of the operator
		List<PhysicalOperator> succs=getSuccessors(operator);
		//move every succ and its succs into the new plan and then copy their connections as well
		if(succs!=null){
			if(succs!=null && !succs.isEmpty()){
				List<PhysicalOperator> succsCopy=new ArrayList<PhysicalOperator>(succs);
				for(PhysicalOperator succ:succsCopy){
					//move operator and its successors to plan
					PhysicalOperator succClone=moveOpsFromLastSharedToLeaf(succ, newPlan);
					//move connections between op and succ to new plan
					newPlan.connect(operatorClone,  succClone);		
				}
			}
		}
		//remove operator from this plan
		this.remove(operator);
		
		return operatorClone;
	}
	
	/**
	 * empty a physical plan from all of its operators
	 * 
	 */
	public void emptyPlan() {
		Map<OperatorKey, PhysicalOperator> operatorsMap = new HashMap<OperatorKey, PhysicalOperator>(this.getKeys());
		Collection<PhysicalOperator> operators = new ArrayList<PhysicalOperator> (operatorsMap.values());
		for(PhysicalOperator op:operators){
			this.remove(op);
		}
		
		//reset all the fields of this plan
		resetPlan();
	}
	
	
	/**
	 * To replace the load in this plan with the store from the shared plan
	 * @param planWithTempStore
	 * @param planWithSharedStore
	 * @throws VisitorException 
	 */
	public void replaceTmpLoadWithSharedStorage(PhysicalPlan  planWithTempStore, PhysicalPlan planWithSharedStore) throws VisitorException {
		//get the temp store file from planWithTempStore
		POStore tempStore=PlanHelper.getPhysicalOperators(planWithTempStore,POStore.class).get(0);
		
		//get the temp store file name
		String tempStoreFileName = tempStore.getSFile().getFileName();
		
		//get the shared store file name
		String sharedStoreFileName=PlanHelper.getPhysicalOperators(planWithSharedStore,POStore.class).get(0).getSFile().getFileName();
		
		//get the load of temp file
		List<POLoad> planLoads=PlanHelper.getPhysicalOperators(this,POLoad.class);
		POLoad tempLoad=null;
		for(POLoad planLoad:planLoads){
			if(planLoad.getLFile().getFileName().equals(tempStoreFileName)){
				tempLoad=planLoad;
				break;
			}
		}
		
		//change the temp load file name from tmp file name to shared file name
		tempLoad.getLFile().setFileName(sharedStoreFileName);
		
		
		//change the store in planWithTempStore to shared store
		tempStore.getSFile().setFileName(sharedStoreFileName);
		tempStore.setIsTmpStore(false);
	}

	public static List<Pair<PhysicalPlan, PhysicalPlan>> injectStoreAfterMapper(
			PhysicalPlan plan, PhysicalOperator op,
			String discoverPlansLevel, PigContext pigContext) throws PlanException, VisitorException, CloneNotSupportedException {
		
		List<PhysicalPlan> returnPlans=new ArrayList<PhysicalPlan>();
		List<POLoad> planLoads= PlanHelper.getPhysicalOperators(plan,POLoad.class);//plan.getRoots();
		List<POStore> planStores= PlanHelper.getPhysicalOperators(plan,POStore.class);
		List<Pair<PhysicalPlan, PhysicalPlan>> newMapperRootPlans = new ArrayList<Pair<PhysicalPlan, PhysicalPlan>>();
			
		//for every predecessor of the op operator
		List<PhysicalOperator> preds=new ArrayList<PhysicalOperator> ();
		List<PhysicalOperator> predsOr=plan.getPredecessors(op);
		if(predsOr!=null){
			preds.addAll(predsOr);
		}
		
		for(PhysicalOperator pred: preds){
			//check if the pred op is a load then skip
			if(!(pred instanceof POLoad)){
				//if heuristics used, then it has to be filter or for each
				if(discoverPlansLevel.equalsIgnoreCase(RESTORE_DISCOVER_HEURISTIC_CONS)||discoverPlansLevel.equalsIgnoreCase(RESTORE_DISCOVER_HEURISTIC_AGG)){
					//the op has to be filter or for each
					if(pred instanceof POFilter || pred instanceof POForEach){
						POLoad load = plan.getLoadForOp(pred, planLoads);
						//inject store regardless the type of the op
						plan.splitPlan(load , pred, pigContext,planStores, planLoads, newMapperRootPlans);
						//add the new discovered roots to the return type
						
					}else{
						//call function for predicates of this op
						List<Pair<PhysicalPlan, PhysicalPlan>> mapperRootPlans = injectStoreAfterMapper(plan, pred, discoverPlansLevel, pigContext);
						newMapperRootPlans.addAll(mapperRootPlans);
					}
				}else{
					
					POLoad load = plan.getLoadForOp(pred, planLoads);
					//inject store regardless the type of the op
					plan.splitPlan(load , pred, pigContext,planStores, planLoads, newMapperRootPlans);
				}
			}
		}
		
		return newMapperRootPlans;
	}

	
	private POLoad getLoadForOp(PhysicalOperator op,
			List<POLoad> planLoads) {
		
		for(POLoad load:planLoads){
			if(isLoadForOp(load,op)){
				return load;
			}
		}
		return null;
	}

	private boolean isLoadForOp(POLoad load, PhysicalOperator op) {
		//get preds for op
		List<PhysicalOperator> preds = this.getPredecessors(op);
			if(preds!=null){
			for(PhysicalOperator pred :preds){
				if(pred.equals(load)){
					return true;
				}
				boolean isPred=isLoadForOp(load, pred);
				if(isPred){
					return true;
				}
			}
		}
		return false;
	}
	
	public static void injectStoreAfterReducer(PhysicalPlan plan, PhysicalOperator op, 
			List<PhysicalPlan> returnPlans, String discoverPlansLevel, PigContext pigContext, 
			List<POStore> stores) throws PlanException, CloneNotSupportedException {
		if(hasStoreSuccessor(op, plan)){
			return;
		}
		//check the heuristic level
		if(discoverPlansLevel.equalsIgnoreCase(RESTORE_DISCOVER_HEURISTIC_AGG) && !isAggOperator(op)){
			return;
		}
		
		//split the plan 
		plan.splitReducerPlan(op, returnPlans, pigContext, stores);
	}
	
	private static boolean isAggOperator(PhysicalOperator op) {
		if(op instanceof POFilter || op instanceof POForEach || 
				op instanceof POFRJoin || op instanceof POJoinPackage || op instanceof POMergeJoin ||
				op instanceof POMergeCogroup || op instanceof POMultiQueryPackage || op instanceof POPackage ||
				op instanceof POPackageLite || op instanceof POUnion){
			return true;
		}
		return false;
	}

}
