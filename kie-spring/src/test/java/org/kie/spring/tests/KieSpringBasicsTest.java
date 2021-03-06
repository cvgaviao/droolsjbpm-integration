/*
 * Copyright 2013 JBoss Inc
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

package org.kie.spring.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.spring.KieSpringUtils;
import org.kie.spring.beans.Person;
import org.kie.spring.beans.SampleBean;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class KieSpringBasicsTest {

    static ApplicationContext context = null;

    @BeforeClass
    public static void setup() {
        context = KieSpringUtils.getDefaultSpringContext();
        assertNotNull(context);
    }

    @Test
    public void testKieBase() throws Exception {
        KieBase kbase = (KieBase) context.getBean("drl_kiesample2");
        assertNotNull(kbase);
    }

//    @Test
//    public void testReleaseId() throws Exception {
//        ReleaseId releaseId = (ReleaseId) context.getBean("dummyReleaseId");
//        assertNotNull(releaseId);
//    }

    @Test
    public void testStatelessKieSession() throws Exception {
        StatelessKieSession ksession = (StatelessKieSession) context.getBean("ksession3");
        assertNotNull(ksession);
    }

    @Test
    public void testKieSession() throws Exception {
        KieSession ksession = (KieSession) context.getBean("statefulSession");
        assertNotNull(ksession);
    }

    @Test
    public void testKSessionExecution() throws Exception {
        StatelessKieSession ksession = (StatelessKieSession) context.getBean("ksession3");
        assertNotNull(ksession);
        Person person = new Person("HAL", 42);
        person.setHappy(false);
        ksession.execute(person);
        assertTrue(person.isHappy());
    }

    @Test
    public void testKSessionInjection() throws Exception {
        SampleBean sampleBean = (SampleBean) context.getBean("sampleBean");
        assertNotNull(sampleBean);
        assertNotNull(sampleBean.getKieSession() );
        assertTrue(sampleBean.getKieSession() instanceof StatelessKieSession);
    }

    @AfterClass
    public static void tearDown() {

    }

}
