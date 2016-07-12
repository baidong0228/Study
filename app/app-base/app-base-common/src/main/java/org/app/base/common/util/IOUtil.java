/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.base.common.util;    

import java.io.FileInputStream;
import java.io.IOException;
    
/**
 * IO工具类
 * This class is used for ...   
 * @author Bdong  
 * @version   
 *       1.0, 2016年7月12日 上午11:20:29
 */
public class IOUtil {
	/**
	 * 读取指定文件，按照16进制输出到控制台，每10个byte换行
	 * @param fileName  
	 * @author Bdong
	 * @throws IOException 
	 */
	public static void printHex(String fileName) throws IOException{
		// 输入流，从指定文件中读取字节流
		FileInputStream fis = new FileInputStream(fileName);
		int b;
		int i = 1;
		while ((b = fis.read()) != -1) {
			// 如果读到的字节是1位，则补零
			if (b < 0xf) {
				System.out.print("0");
			}
			// 转换成16进制输出到控制台
			System.out.print(Integer.toHexString(b) + " ");
			if (i++ % 10 == 0) {// 如果读到10个byte则换行
				System.out.println();
			}
		}
		// 关闭字节流
		fis.close();
	}
}
  