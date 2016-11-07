/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.management.web.aspect;    

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class BdAspect implements MethodInterceptor{
	private static Logger logger = Logger.getLogger("BdAspect");

	public void before(){
		logger.info("BdAspect before()");
	}
	
	public void afterReturning(){
		System.out.println("afterReturning");
	}

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		return null;
	}
}
  