package com.wt.netty.rpc.test.server;

import com.wt.netty.rpc.server.ServerSocket;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/9 9:53
 */
public class StartServer {
    public static void main(String[] args) {
        System.out.println("启动服务端开始");
        new Thread(new ServerSocket()).start();
        System.out.println("启动服务端完成");
    }
}
