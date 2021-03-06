package org.apache.pig.backend.hadoop.executionengine.mapReduceLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.relationalOperators.POStore;
import org.apache.pig.tools.pigstats.JobStats;
import org.apache.pig.tools.pigstats.OutputStats;
import org.mortbay.log.Log;

public class SharedMapReducePlan implements Serializable {

	MapReduceOper mrplan;
	double planCost;
	POStore jobStore;
	String jobStoreLocation;
	
	private long hdfsBytesWritten = 0;
   
	private long hdfsBytesRead = 0;
    
	private double readWriteRatio=0;
    
    private long avgMapTime = 0;
    private long avgReduceTime = 0;
    private long avgPlanTime = 0;
    
    private List<String> jobForInputInfo=null;
	    
    private boolean isDiscoveredPlan;
    private boolean hasReduceOp;
	

	

	public SharedMapReducePlan(MapReduceOper mrplan, POStore jobStore, String jobStoreLocation){
		this(mrplan, 0, jobStore, jobStoreLocation);
	}

	SharedMapReducePlan(MapReduceOper mrplan, double planCost,
			POStore jobStore, String jobStoreLocation) {
		this.mrplan=mrplan;
		this.planCost=planCost;
		this.jobStore=jobStore;
		if(jobStoreLocation!=null){
			this.jobStoreLocation=new String(jobStoreLocation);
		}else{
			this.jobStoreLocation=null;
		}
		this.isDiscoveredPlan=false;
		if(mrplan.reducePlan==null || mrplan.reducePlan.isEmpty()){
			this.hasReduceOp=false;
		}else{
			this.hasReduceOp=true;
		}
		
	}
	
	public SharedMapReducePlan(SharedMapReducePlan sharedPlan) {
		this.mrplan=sharedPlan.mrplan;
		this.planCost=sharedPlan.planCost;
		this.jobStore=sharedPlan.jobStore;
		if(sharedPlan.jobStoreLocation!=null){
			this.jobStoreLocation=new String(sharedPlan.jobStoreLocation);
		}else{
			this.jobStoreLocation=null;
		}
		if(sharedPlan.jobForInputInfo!=null){
			this.jobForInputInfo=new ArrayList<String>(sharedPlan.jobForInputInfo);
		}
		this.hasReduceOp=sharedPlan.hasReduceOp;
	}
	
	

	public double getPlanCost() {
		return planCost;
	}

	public void setPlanCost(double planCost) {
		this.planCost = planCost;
	}

	public long getHdfsBytesRead() {
		return hdfsBytesRead;
	}
	
	public void setHdfsBytesRead(long hdfsBytesRead) {
		this.hdfsBytesRead += hdfsBytesRead;
	}
	
	public long getAvgPlanTime() {
		return avgPlanTime;
	}

	public void setAvgPlanTime(long avgPlanTime) {
		this.avgPlanTime += avgPlanTime;
	}
	
	public MapReduceOper getMRPlan() {
		return this.mrplan;
	}

	/**
	 * 
	 * @param jobStats
	 * @author iman
	 */
	public void updateStats(JobStats jobStats) {
		if(jobStats!=null){
			jobStats.getMapInputRecords();
			jobStats.getMapOutputRecords();
			jobStats.getReduceOutputRecords();
			hdfsBytesWritten=jobStats.getHdfsBytesWritten();
			if(hdfsBytesRead<=0){
				hdfsBytesRead=jobStats.getHdfsBytesRead();
			}
			avgMapTime=jobStats.getAvgMapTime();
			avgReduceTime=jobStats.getAvgREduceTime();
			
			//calculate read/write ratio
			if(hdfsBytesWritten!=0){
				readWriteRatio=hdfsBytesRead*1d/hdfsBytesWritten;
			}
			//calculate avgPlanTime
			avgPlanTime=avgPlanTime+avgMapTime+avgReduceTime;
		}
	}
	
	/**
	 * To update a discovered plan with stats -- the input and o/p are for a sub plan not the entire plan
	 * @param jobStats
	 * @author iman
	 */
	public void updateDiscoveredPlanStats(JobStats jobStats) {
		//get the o/p location of this shared job
		String storeLocation=jobStoreLocation;
		
		if(jobStats!=null){
			//get the set of o/ps of this job 
			List<OutputStats> jobOutputs = jobStats.getOutputs();
			OutputStats subPlanOutput=null;
			//get the stats of the o/p that matches this plan
			for(OutputStats outStat:jobOutputs){
				if(storeLocation.equals(outStat.getLocation())){
					subPlanOutput=outStat;
					break;
				}
			}
			
			if(storeLocation==null){
				Log.warn("Could not find output information about the sub plan in the jobstats collected for the job!");
				//TODO  throw an exception
				return;
			}
			jobStats.getMapInputRecords();
			
			subPlanOutput.getNumberRecords();
			
			hdfsBytesWritten=subPlanOutput.getBytes();//jobStats.getHdfsBytesWritten();
			
			if(hdfsBytesRead<=0){
				hdfsBytesRead=jobStats.getHdfsBytesRead();
			}
			avgMapTime=jobStats.getAvgMapTime();
			//the discovered plans are map only jobs
			avgReduceTime=0;//jobStats.getAvgREduceTime();
			
			//calculate read/write ratio
			if(hdfsBytesWritten!=0){
				readWriteRatio=hdfsBytesRead*1d/hdfsBytesWritten;
			}
			//calculate avgPlanTime
			avgPlanTime=avgPlanTime+avgMapTime+avgReduceTime;
		}
	}
	
	/**
	 * 
	 * @return
	 * @author iman
	 */
	public double getReadWriteRatio(){
		return readWriteRatio;
	}
	
	public long getHdfsBytesWritten() {
		return hdfsBytesWritten;
	}
	 
	public boolean isGoodPlan(){
		return readWriteRatio>0? true:false;
	}
	/**
	 * Compares a MR plan with this shared plan and returns true if that other plan is better 
	 * @param otherPlan
	 * @return
	 * 
	 */
	public boolean isBetterPlan(SharedMapReducePlan otherPlan){
		
		if(hasReduceOp && !otherPlan.hasReduceOp){
			return true;
		}
		if(!hasReduceOp && otherPlan.hasReduceOp){
			return false;
		}
		if(readWriteRatio>otherPlan.readWriteRatio){
			return true;
		}else if(readWriteRatio==otherPlan.readWriteRatio){
			if(avgPlanTime>otherPlan.avgPlanTime){
				return true;
			}
		}
		return false;
	}

	public void setJobForInputInfo(String jobID) {
		if(jobID!=null){
			if(this.jobForInputInfo==null){
				this.jobForInputInfo=new ArrayList<String>();
			}
			this.jobForInputInfo.add(new String(jobID));
		}
	}

	public List<String> getJobForInputInfo() {
		return jobForInputInfo;
	}

	public boolean isDiscoveredPlan() {
		return isDiscoveredPlan;
	}

	public void setDiscoveredPlan(boolean isDiscoveredPlan) {
		this.isDiscoveredPlan = isDiscoveredPlan;
	}
	
}
