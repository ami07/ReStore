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
package org.apache.pig.backend.hadoop.executionengine.physicalLayer.expressionOperators;

import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.POStatus;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.PhysicalOperator;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.Result;
import org.apache.pig.backend.hadoop.executionengine.physicalLayer.plans.PhyPlanVisitor;
import org.apache.pig.data.DataType;
import org.apache.pig.impl.plan.OperatorKey;
import org.apache.pig.impl.plan.NodeIdGenerator;
import org.apache.pig.impl.plan.VisitorException;

public class Mod extends BinaryExpressionOperator {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Mod(OperatorKey k) {
        super(k);
    }

    public Mod(OperatorKey k, int rp) {
        super(k, rp);
    }

    @Override
    public void visit(PhyPlanVisitor v) throws VisitorException {
        v.visitMod(this);
    }

    @Override
    public String name() {
        return "Mod" + "[" + DataType.findTypeName(resultType) + "]" +" - " + mKey.toString();
    }

    @SuppressWarnings("unchecked")
    protected <T extends Number> T mod(T a, T b, byte dataType) throws ExecException {
        switch(dataType) {
        case DataType.INTEGER:
            return (T) Integer.valueOf((Integer) a % (Integer) b);
        case DataType.LONG:
            return (T) Long.valueOf((Long) a % (Long) b);
        default:
            throw new ExecException("called on unsupported Number class " + DataType.findTypeName(dataType));
        }
    }

    @SuppressWarnings("unchecked")
    protected <T extends Number> Result genericGetNext(T number, byte dataType) throws ExecException {
        Result r = accumChild(null, number, dataType);
        if (r != null) {
            return r;
        }

        byte status;
        Result res;
        T left = null, right = null;
        res = lhs.getNext(left, dataType);
        status = res.returnStatus;
        if(status != POStatus.STATUS_OK || res.result == null) {
            return res;
        }
        left = (T) res.result;

        res = rhs.getNext(right, dataType);
        status = res.returnStatus;
        if(status != POStatus.STATUS_OK || res.result == null) {
            return res;
        }
        right = (T) res.result;

        res.result = mod(left, right, dataType);
        return res;
    }

    @Override
    public Result getNext(Integer i) throws ExecException{
        return genericGetNext(i, DataType.INTEGER);
    }

    @Override
    public Result getNext(Long i) throws ExecException{
        return genericGetNext(i, DataType.LONG);
    }

    @Override
    public Mod clone() throws CloneNotSupportedException {
        Mod clone = new Mod(new OperatorKey(mKey.scope,
            NodeIdGenerator.getGenerator().getNextNodeId(mKey.scope)));
        clone.cloneHelper(this);
        return clone;
    }
    
    /**
	 * @author iman
	 */
    @Override
	public boolean isEquivalent(PhysicalOperator otherOP) {
		if(otherOP instanceof Mod){
			//the other operator is also an Divide then there is a possibility of equivalence
			if(lhs.isEquivalent(((BinaryExpressionOperator) otherOP).getLhs())&& rhs.isEquivalent(((BinaryExpressionOperator) otherOP).getRhs())){
				return true;
			}
		}
		return false;
	}

}
