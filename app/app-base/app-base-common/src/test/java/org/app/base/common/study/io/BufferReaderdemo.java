/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.base.common.study.io;    

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
    
public class BufferReaderdemo {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("/Users/Bdong/Downloads/test.txt")));
		PrintWriter pw = new PrintWriter("/Users/Bdong/Downloads/test1.txt");
		String line ;
		while((line = br.readLine())!=null){
			System.out.println(line);//一次读一行，并不能识别换行
			pw.println(line);
			pw.flush();
		}
		br.close();
		//bw.close();
		pw.close();
	}
}
  