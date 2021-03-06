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
package org.apache.pig;

import java.io.IOException;

import org.apache.pig.Accumulator;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

/**
 * This class is used to provide a free implementation of the EvalFunc exec function given
 * implementation of the Accumulator interface. Instead of having to provide a redundant
 * implementation, this provides the base exec function for free, given that the methods
 * associated with the Accumulator interface are implemented. For information on how to
 * implement Accumulator, see {@link Accumulator}.
 */
public abstract class AccumulatorEvalFunc<T> extends EvalFunc<T> implements Accumulator<T> {

    @Override
    public abstract void accumulate(Tuple b) throws IOException;

    @Override
    public abstract void cleanup();

    @Override
    public abstract T getValue();

    @Override
    public T exec(Tuple input) throws IOException {
        accumulate(input);
        T result = getValue();
        cleanup();
        return result;
    }
    
    @Override
    public boolean isEquivalent(EvalFunc func) {
    	// TODO Auto-generated method stub
    	if(func instanceof AccumulatorEvalFunc){
    		return true;
    	}
    	return false;
    }

}
