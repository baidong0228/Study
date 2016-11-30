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

public class AdultVideoShow1 extends Thread {
    private String name;//名称
    private int count = 1;
    private int perCount = 1;

    public AdultVideoShow1(String name, int perCount) {
        this.name = name;
        this.perCount = perCount;
    }

    public void run() {
        for (int i = 0; i < perCount; i++) {
            System.out.println(name + " 使用了第" + (count++) + "种姿势！");
            try {
                sleep((int) Math.random() * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
  