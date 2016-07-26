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
    
public class AdultVideoShow2 implements Runnable{
	private String name;//名称
	
	public AdultVideoShow2(String name){
		this.name=name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++){
			System.out.println(name+" 使用了第"+(i+1)+"种姿势！");
//			try {
//                sleep((int) Math.random() * 10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
		}
	}

}
  