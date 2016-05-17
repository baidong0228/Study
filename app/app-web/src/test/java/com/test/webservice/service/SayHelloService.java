/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */
package com.test.webservice.service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * webservice服务端测试
 * This class is used for ...
 *
 * @author Bdong
 * @version 1.0, 2016年5月16日 下午4:30:23
 */
@WebService
public class SayHelloService {

    public String getValue(String name) {
        return "Hello," + name + "! This is my first WebService!";
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Endpoint.publish("http://localhost:9001/Service/SayHelloService", new SayHelloService());
        System.out.println("Service success!");
    }

}
  