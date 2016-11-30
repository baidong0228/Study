/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */
package org.app.base.common.study.net.threadtcp;

import java.io.*;
import java.net.Socket;

/**
 * 客户端
 * This class is used for ...
 *
 * @author Bdong
 * @version 1.0, 2016年7月19日 上午9:45:20
 */
public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        PrintWriter pw = null;
        InputStream is = null;
        BufferedReader br = null;
        try {
            socket = new Socket("localhost", 8888);
            System.out.println("客户端已启动*请输入一个字符串**");
            BufferedReader strin = new BufferedReader(new InputStreamReader(
                    System.in));
            String str = strin.readLine();
            os = socket.getOutputStream();
            pw = new PrintWriter(os);

            pw.write(str);
            pw.flush();
            socket.shutdownOutput();

            is = socket.getInputStream();
            br = new BufferedReader(
                    new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println(info);
            }
            socket.shutdownInput();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (is != null)
                    is.close();
                if (pw != null)
                    pw.close();
                if (os != null)
                    os.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
  