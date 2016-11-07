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

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.app.base.common.utils.IOUtils;

public class DataOutputStreamDemo {
	public static void main(String[] args) throws IOException{
		String file = "/Users/Bdong/Downloads/test.txt";
		// TODO Auto-generated method stub
		// 如果该文件不存在，则直接创建，如果存在，删除后创建
		FileOutputStream out = new FileOutputStream(file);
		DataOutputStream dos =new DataOutputStream(out);
		dos.writeInt(10);
		int a = 10;// write只能写八位,那么写一个int需要写4次每次8位
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a);
		
		
		dos.close();
		out.close();

		IOUtils.printHex(file);
	}
}
  