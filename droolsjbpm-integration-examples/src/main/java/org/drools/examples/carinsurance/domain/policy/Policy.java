/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.examples.carinsurance.domain.policy;

import java.math.BigDecimal;
import java.util.List;

import org.drools.examples.carinsurance.domain.Car;
import org.drools.examples.carinsurance.domain.Driver;

public class Policy {

    private Car car;
    private Driver owner;
    private List<Coverage> coverageList;

    private BigDecimal totalPremium;

    // ############################################################################
    // Non getters and setters
    // ############################################################################
    
}