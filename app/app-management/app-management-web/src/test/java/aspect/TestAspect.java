/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package aspect;    

import org.app.management.web.aspect.AspectBiz;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
    
public class TestAspect {
	private ApplicationContext ac = null;
	
	@Before
	public void before() {
		ac = new ClassPathXmlApplicationContext("spring-config-aop.xml");
		System.out.println(ac.getApplicationName());
	}
	
	@Test
	public void test() {
		AspectBiz ab =(AspectBiz) ac.getBean("aspectBiz");
		ab.biz();
	}
}
  