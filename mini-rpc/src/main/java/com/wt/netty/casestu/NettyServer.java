package com.wt.netty.casestu;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/1/2 12:07
 */
public class NettyServer {
    /**
     * 1. 创建bossGroup线程组: 处理网络事件--连接事件
     * 2. 创建workerGroup线程组: 处理网络事件--读写事件
     * 3. 创建服务端启动助手
     * 4. 设置bossGroup线程组和workerGroup线程组
     * 5. 设置服务端通道实现为NIO
     * 6. 参数设置
     * 7. 创建一个通道初始化对象
     * 8. 向pipeline中添加自定义业务处理handler
     * 9. 启动服务端并绑定端口,同时将异步改为同步
     * 10. 关闭通道和关闭连接池
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
//                        ch.pipeline().addLast(new MessageDecoder());
//                        ch.pipeline().addLast(new MessageEncoder());
                        ch.pipeline().addLast(new MessageCoder());
                        ch.pipeline().addLast(new NettyServerHandler());
                    }
                });
        //启动服务端并绑定端口,同时将异步改为同步
        ChannelFuture channelFuture = bootstrap.bind(9999);
        channelFuture.addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("服务器绑定端口成功！");
            } else {
                System.out.println("服务器绑定端口失败！");
            }
        });
        System.out.println("服务器启动成功。。。。");
        channelFuture.channel().closeFuture().sync();
        //关闭通道(并不是真正意义上的关闭,而是监听通道关闭状态)和关闭连接池
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }
}
