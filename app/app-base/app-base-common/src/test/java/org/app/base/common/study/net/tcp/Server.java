/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.base.common.study.net.tcp;    

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
    
/**
 * 服务端
 * This class is used for ...   
 * @author Bdong  
 * @version   
 *       1.0, 2016年7月19日 上午9:44:41
 */
public class Server {
	
	public static void main(String[] args) {
		Socket socket= null;
		InputStream is=null;
		BufferedReader br=null;
		OutputStream os =null;
		PrintWriter pw =null;
		ServerSocket serverSocket =null;
		System.out.println("***服务器已启动，监听客户端的连接：8888***");
		
		try {
			serverSocket =new ServerSocket(8888);//指定服务端监听端口
			socket = serverSocket.accept();//建立socket
			is = socket.getInputStream();//从socket中接收服务端数据
			br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println(info);
			}
			
			os =socket.getOutputStream();//将返回信息放入socket
			pw =new PrintWriter(os);
			pw.write("欢迎！");
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(pw!=null)
					pw.close();
				if(os!=null)
					os.close();
				if(br!=null)
					br.close();
				if(is!=null)
					is.close();
				if(socket!=null)
					socket.close();
				if(serverSocket!=null)
					serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
  