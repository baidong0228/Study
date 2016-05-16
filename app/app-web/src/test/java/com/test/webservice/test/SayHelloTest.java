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
			// 换成对应的proxy类
			SayHelloServiceProxy proxy = new SayHelloServiceProxy();
			proxy.setEndpoint("http://localhost:9001/Service/SayHelloService");
			// 换成获取对应的serice
			SayHelloService service = proxy.getSayHelloService();
			// 调用web service提供的方法
			String result = service.getValue("bdong");

			System.out.println(result);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
  