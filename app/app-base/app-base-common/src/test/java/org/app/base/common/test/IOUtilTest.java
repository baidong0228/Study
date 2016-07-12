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

import java.io.IOException;

import org.app.base.common.util.IOUtil;
    
public class IOUtilTest {

	public static void main(String args[]){
		try {
			IOUtil.printHex("/Users/Bdong/Downloads/2016/month_rain_trend_201611.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
  