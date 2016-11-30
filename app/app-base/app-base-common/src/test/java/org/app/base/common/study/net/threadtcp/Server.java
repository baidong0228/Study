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

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * This class is used for ...
 *
 * @author Bdong
 * @version 1.0, 2016年7月19日 上午9:44:41
 */
public class Server {

    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket serverSocket = null;
        System.out.println("***服务器已启动，监听客户端的连接：8888***");

        try {
            serverSocket = new ServerSocket(8888);
            int count = 0;
            while (true) {
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println(count);
                System.out.println(socket.getInetAddress());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (socket != null)
                    socket.close();
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }
}
  