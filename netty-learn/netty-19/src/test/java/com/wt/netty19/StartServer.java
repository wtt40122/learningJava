package com.wt.netty19;

import com.wt.netty19.server.ServerSocket;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/4 16:26
 */
public class StartServer {
    public static void main(String[] args) {
        new Thread(new ServerSocket()).start();
        System.out.println("netty server start done.");
    }
}
