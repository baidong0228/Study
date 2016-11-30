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

import java.io.File;

/**
 * 文件操作工具
 * This class is used for ...
 *
 * @author Bdong
 * @version 1.0, 2016年7月11日 下午10:10:42
 */
public class FileUtils {
    /**
     * 列出指定目录下所有的内容
     *
     * @param dir
     * @author Bdong
     */
    public static void listDirectory(File dir) {
        //目录不存在
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录：" + dir + "不存在！");
        }
        //不是目录
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是目录！");
        }
        //列出所有File
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    //如果file是目录，则递归调用该方法
                    listDirectory(file);
                } else {
                    //如果是文件，就打印文件名
                    System.out.println(file);
                }
            }
        }
    }
}
  