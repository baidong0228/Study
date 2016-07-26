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
import java.net.Socket;
    
/**
 * 客户端
 * This class is used for ...   
 * @author Bdong  
 * @version   
 *       1.0, 2016年7月19日 上午9:45:20
 */
public class Client {

	public static void main(String[] args) {
		Socket socket = null;
		OutputStream os =null;
		PrintWriter pw =null;
		InputStream is =null;
		BufferedReader br =null;
		try {
			socket = new Socket("localhost",8888);//建立socket
			System.out.println("客户端已启动***");
			os =socket.getOutputStream();//将客户端请求放入socket
			pw =new PrintWriter(os);
			pw.write("小泽玛利亚|Maria Ozawa|(88-58-86)cm,(35-23-34)in|E");
			pw.flush();
			socket.shutdownOutput();
			
			is =socket.getInputStream();//从socket取出服务端数据
			br =new BufferedReader(
					new InputStreamReader(is));
			String info=null;
			while((info=br.readLine())!=null){
				System.out.println(info);
			}
			socket.shutdownInput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(br!=null)
					br.close();
				if(is!=null)
					is.close();
				if(pw!=null)
					pw.close();
				if(os!=null)
					os.close();
				if(socket!=null)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
  