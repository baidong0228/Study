/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.base.service;    


import org.apache.log4j.Logger;
import org.app.base.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.transaction.TransactionConfiguration;
    

/**
 * TestMyBatis
 * This class is used for ...   
 * @author Bdong  
 * @version   
 *       1.0, 2016年5月26日 下午5:52:24
 */
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestMyBatis {
	private static Logger logger = Logger.getLogger("TestMyBatis");
	private ApplicationContext ac = null;
	@Autowired
	private IPersonServiceTest personServiceTest;

	@Before
	public void before() {
		ac = new ClassPathXmlApplicationContext("spring-config-mybatis.xml");
		personServiceTest = (IPersonServiceTest) ac.getBean("personServiceTest");
	}

	@Test
	public void test() {
		Person person = personServiceTest.selectByPrimaryKey(1);
		logger.info("Name:" + person.getName());
	}
}
  