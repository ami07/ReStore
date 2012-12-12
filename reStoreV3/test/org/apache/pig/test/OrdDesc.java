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
package org.apache.pig.test;

import org.apache.pig.data.Tuple;
import org.apache.pig.ComparisonFunc;

public class OrdDesc extends ComparisonFunc {
    // this is a simple example - more complex comparison will require
    //   breakout of the individual values. I suggest you'll have
    //   to convert "catch(IOException e) to RuntimeException('msg', e)"
    public int compare(Tuple t1, Tuple t2) {
        return t2.compareTo(t1);
    }
    
    @Override
	public boolean isEquivalent(ComparisonFunc func) {
		if(func instanceof OrdDesc){
			return true;
		}
		return false;
	}
}
