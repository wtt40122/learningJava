package com.wt.netty07;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/1 11:31
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        System.out.println("链接报告开始");
        System.out.println("链接报告信息：本客户端链接到服务端。channelId：" + ch.id());
        System.out.println("链接报告完毕");
    }
}
