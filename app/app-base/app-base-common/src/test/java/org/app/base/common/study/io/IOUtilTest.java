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

import org.app.base.common.utils.IOUtils;

import java.io.File;
import java.io.IOException;


public class IOUtilTest {

	public static void main(String args[]){
		try {
			long start=System.currentTimeMillis();
			IOUtils.copyFile(new File("/Users/Bdong/360云盘/Mac/Mac.xlsx"),new File("/Users/Bdong/Downloads/1.xlsx"));
			long end=System.currentTimeMillis();
			System.out.println();
			System.out.println("花费"+(end-start)+"毫秒");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
  