package com.wt.netty16;

import com.wt.netty16.server.NettyServer;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/3 18:57
 */
public class NettyServerTest {
    public static void main(String[] args) {
        System.out.println("hi");
        //启动服务
        new NettyServer().bind(7397);
    }

}
