/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */
package com.test.webservice.test;

import java.rmi.RemoteException;

import com.test.webservice.client.SayHelloService;
import com.test.webservice.client.SayHelloServiceProxy;

public class SayHelloTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            // 实例化proxy类
            SayHelloServiceProxy proxy = new SayHelloServiceProxy();
            //设置服务地址
            proxy.setEndpoint("http://localhost:9001/Service/SayHelloService");
            // 调用接口
            String result=proxy.getValue("bdong");
//
            System.out.println(result);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
  