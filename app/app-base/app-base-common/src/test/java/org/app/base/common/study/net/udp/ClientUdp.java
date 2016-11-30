/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */
package org.app.base.common.study.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUdp {
    public static void main(String[] args) {
        try {
            /*
			 * 向服务器端发送数据
			 */
            //定义需要连接的服务地址
            InetAddress address = InetAddress.getByName("127.0.0.1");
            //定义端口号
            int port = 8888;
            //定义发送数据
            byte[] bytes = "隔壁老王".getBytes();
            //创建数据报
            DatagramPacket udpPacket = new DatagramPacket(bytes, bytes.length, address, port);
            //创建DatagramSocket对象
            DatagramSocket socket = new DatagramSocket();
            //向服务器端发送数据报
            socket.send(udpPacket);
			
			
			/*
			 * 接收服务器端响应的数据
			 */
            //1.创建数据报，用于接收服务器端响应的数据
            byte[] data2 = new byte[1024];
            DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
            //2.接收服务器响应的数据
            socket.receive(packet2);
            //3.读取数据
            String reply = new String(data2, 0, packet2.getLength());
            System.out.println("服务器说：" + reply);
            //4.关闭资源
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
  