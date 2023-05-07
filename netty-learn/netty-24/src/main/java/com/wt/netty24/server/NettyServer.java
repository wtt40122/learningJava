package com.wt.netty24.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: wtt
 * @Date: 2023/5/7 16:37
 * @Description:
 */
public class NettyServer {

    public static void main(String[] args) {
        new NettyServer().bind(7397);
    }


    private void bind(int port) {
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(parentGroup, childGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new ServerChannelInitializer());

            ChannelFuture channelFuture = bootstrap.bind(port).sync();
            System.out.println("netty server start done. ");
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            childGroup.shutdownGracefully();
            parentGroup.shutdownGracefully();
        }

    }
}
