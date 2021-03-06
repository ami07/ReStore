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
package org.apache.pig.builtin;

import org.apache.pig.EvalFunc;

/**
 * This method should never be used directly, use {@link MAX}.
 */
public class FloatMax extends AlgebraicFloatMathBase {

    public FloatMax() {
        setOp(KNOWN_OP.MAX);
    }

    public static class Intermediate extends AlgebraicFloatMathBase.Intermediate {
        @Override
        public KNOWN_OP getOp() {
            return KNOWN_OP.MAX;
            }
        
        @Override
    	public boolean isEquivalent(EvalFunc func) {
    		if(func instanceof Intermediate){
    			return true;
    		}
    		return false;
    	}
        }
    
    public static class Final extends AlgebraicFloatMathBase.Final {
    @Override
        public KNOWN_OP getOp() {
            return KNOWN_OP.MAX;
        }
    
    @Override
	public boolean isEquivalent(EvalFunc func) {
		if(func instanceof Final){
			return true;
		}
		return false;
	}
    }

    @Override
	public boolean isEquivalent(EvalFunc func) {
		if(func instanceof FloatMax){
			return true;
		}
		return false;
	}
}
