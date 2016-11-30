package org.app.base.common.study.io;

import java.io.UnsupportedEncodingException;
/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */

/**
 * This class is used for ...
 *
 * @author Bdong
 * @version 1.0, 2016年5月3日 下午3:28:36
 */
class EncodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s1 = "字符串ABC";
        byte[] bytes_utf_8 = s1.getBytes();//使用项目默认编码转换成字节序列
        byte[] bytes_gbk = s1.getBytes("gbk");//使用指定编码（gbk）转换成字节序列
        System.out.println("utf_8:");
        for (byte b1 : bytes_utf_8) {
            //把byte转换为16进制的int进行展示
            System.out.print(Integer.toHexString(b1 & 0xff) + " ");
        }
        System.out.println();
        System.out.println("gbk:");
        for (byte b1 : bytes_gbk) {
            //把byte转换为16进制的int进行展示
            System.out.print(Integer.toHexString(b1 & 0xff) + " ");
        }
    }
}
  