package com.wt.netty09.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/1 11:36
 */
public class NettyClient {

    public static void main(String[] args) {
        new NettyClient().connect("127.0.0.1", 7397);
    }

    private void connect(String inetHost, int inetPort) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.AUTO_READ, true);
            b.handler(new MyChannelInitializer());
            ChannelFuture f = b.connect(inetHost, inetPort).sync();
            System.out.println("itstack-demo-netty client start done.");
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
