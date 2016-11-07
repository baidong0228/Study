/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.base.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
    
/**
 * IO工具类
 * This class is used for ...   
 * @author Bdong  
 * @version   
 *       1.0, 2016年7月12日 上午11:20:29
 */
public class IOUtils {
	/**
	 * 读取指定文件，按照16进制输出到控制台，每10个byte换行
	 * (单字节读取，不适合大文件)
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
	
	/**
	 * 批量读取，适合大文件
	 * @param fileName
	 * @throws IOException  
	 * @author Bdong
	 */
	public static void printHexByByteArray(String fileName) throws IOException{
		// 输入流，从指定文件中读取字节流
		FileInputStream fis = new FileInputStream(fileName);
		byte[] buf = new byte[8*1024];
		int bytes = 0;
		int j=1;
		while ((bytes = fis.read(buf, 0, buf.length)) != -1) {
			for(int i=0;i<bytes;i++){
				// 转换成16进制输出到控制台
				System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
				if (j++ % 10 == 0) {// 如果读到10个byte则换行
					System.out.println();
				}
			}
		}
		// 关闭字节流
		fis.close();
	}
	
	/**
	 * 批量方式拷贝文件，大文件时速度最快
	 * @param srcFile
	 * @param destFile
	 * @throws IOException  
	 * @author Bdong
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件："+srcFile+"不存在！");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"不是文件！");
		}
		//输入流
		FileInputStream fis =new FileInputStream(srcFile);
		//输出流
		FileOutputStream fos =new FileOutputStream(destFile);
		//缓冲区
		byte[] buf =new byte[8*1024];
		int bytes;
		while((bytes=fis.read(buf, 0, buf.length))!=-1){
			fos.write(buf,0,bytes);
			fos.flush();
		}
		fos.close();
		fis.close();
	}
	
	/**
	 * 缓冲方式拷贝文件
	 * @param srcFile
	 * @param destFile
	 * @throws IOException  
	 * @author Bdong
	 */
	public static void copyFileByBuffer(File srcFile, File destFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件："+srcFile+"不存在！");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"不是文件！");
		}
		//带缓冲的输入流
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(srcFile));
		//带缓冲的输出流
		BufferedOutputStream bos =new BufferedOutputStream(new FileOutputStream(destFile));
		int c;
		while((c=bis.read())!=-1){
			bos.write(c);
			bos.flush();//刷新缓冲区
		}
		bos.close();
		bis.close();
	}
}
  