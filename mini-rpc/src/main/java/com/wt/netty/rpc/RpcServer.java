package com.wt.netty.rpc;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/1/3 22:46
 */
public class RpcServer {

    private static RpcServerHandler rpcServerHandler;
    private NioEventLoopGroup bossGroup;
    private NioEventLoopGroup workGroup;

    public void startServer(String ip, int port) {

        try {
            bossGroup = new NioEventLoopGroup(1);
            workGroup = new NioEventLoopGroup();
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(rpcServerHandler);
                        }
                    });
            ChannelFuture channelFuture = bootstrap.bind(ip, port).sync();
            System.out.println("服务端启动成功-----");
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (bossGroup != null) {
                bossGroup.shutdownGracefully();
            }
            if (workGroup != null) {
                workGroup.shutdownGracefully();
            }

        }
    }

    public static void main(String[] args) {
        rpcServerHandler = new RpcServerHandler();
        RpcServer rpcServer = new RpcServer();
        rpcServer.startServer("127.0.0.1", 9799);
    }
}
