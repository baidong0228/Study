/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.base.common.study.thread;    
    
public class Main {
	public static void main(String[] args) {
		new AdultVideoShow1("泷泽萝拉").start();
		new AdultVideoShow1("苍井空").start();
		
		new Thread(new AdultVideoShow2("小泽玛利亚")).start();
		new Thread(new AdultVideoShow2("波多野结衣")).start();
	}
}
  