/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.base.common.study.reflection;    

import org.app.base.common.excel.AdultVideoStar;
import org.app.base.common.util.ClassUtil;
    
public class GetClass {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class c1 = AdultVideoStar.class;//通过类获取Class，任何一个类都有一个隐含的class静态成员变量。
		Class c2 = (new AdultVideoStar()).getClass();//通过类的实例对象，获取该类的Class。
		Class c3 = Class.forName("org.app.base.common.excel.AdultVideoStar");//动态加载（包名+类名）
		System.out.println(c1==c2);
		System.out.println(c2==c3);
		
		AdultVideoStar av =(AdultVideoStar)c3.newInstance();
		ClassUtil.printClassMethodMessage(av);
		ClassUtil.printConMessage(av);
//		System.out.println(av);
	}
}
  
