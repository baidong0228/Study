/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */
package org.app.base.common.study.thread.one;

public class AdultVideoShow2 implements Runnable, AdultVideo {
    private int count = 1;//总动作数
    private int perCount = 1;//每人动作数
    private final Object lockObj = new Object();//锁

    public AdultVideoShow2() {
    }

    public AdultVideoShow2(int perCount) {
        this.perCount = perCount;
    }

    @Override
    public void run() {
        synchronized (lockObj) {
            for (int i = 0; i < perCount; i++) {
                System.out.println(Thread.currentThread().getName() + " 使用了第" + (count++) + "种姿势！");
            }
            lockObj.notifyAll();//
        }
    }

    //条件争用
//	@Override
//	public void run() {
//		for (int i = 0; i < perCount; i++) {
//			System.out.println(Thread.currentThread().getName() + " 使用了第"
//					+ (count++) + "种姿势！");
//		}
//	}

    @Override
    public void warning() {
        // TODO Auto-generated method stub
        System.out.println("                       FBI WARNING!     ");
        System.out.println("Federal Law provides severe civil and criminal penalties for");
        System.out.println("the unauthorized reproduction,distribution,or exhibition of ");
        System.out.println("copyrighted motion pictures!");
        System.out.println();
    }

}
  