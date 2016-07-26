/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.base.common.test;    

import java.io.File;

import org.app.base.common.util.FileUtil;
    
public class FileUtilTest {
	public static void main(String args[]){
		File file1=new File("/Users/Bdong/Downloads/nari20160711");
		FileUtil.listDirectory(file1);
	}
}
  