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
    
public class ServerUdp {
	public static void main(String[] args) {
		try {
			/*
			 * 接收客户端发送的数据
			 */
			//1.创建服务器端DatagramSocket，指定端口
			DatagramSocket udpSocket =new DatagramSocket(8888);
			//2.创建数据报，用于接收客户端发送的数据
			byte[] data =new byte[1024];//创建字节数组，指定接收的数据包的大小
			DatagramPacket udpPacket= new  DatagramPacket(data, 0, data.length);
			//3.接收客户端发送的数据
			System.out.println("****服务器端已经启动，等待客户端发送数据");
			udpSocket.receive(udpPacket);
			String info=new String(data, 0, udpPacket.getLength());
			System.out.println("客户端消息："+info);
			
			
			/*
			 * 向客户端响应数据
			 */
			//1.定义客户端的地址、端口号、数据
			InetAddress address=udpPacket.getAddress();
			int port=udpPacket.getPort();
			byte[] data2="欢迎您!".getBytes();
			//2.创建数据报，包含响应的数据信息
			DatagramPacket packet2=new DatagramPacket(data2, data2.length, address, port);
			//3.响应客户端
			udpSocket.send(packet2);
			//4.关闭资源
			udpSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
  