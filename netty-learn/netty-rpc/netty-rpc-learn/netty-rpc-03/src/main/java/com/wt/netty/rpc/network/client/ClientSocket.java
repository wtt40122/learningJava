package com.wt.netty.rpc.network.client;

import com.wt.netty.rpc.network.codec.RpcDecoder;
import com.wt.netty.rpc.network.codec.RpcEncoder;
import com.wt.netty.rpc.network.msg.Request;
import com.wt.netty.rpc.network.msg.Response;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/10 9:56
 */
public class ClientSocket implements Runnable {
    private ChannelFuture future;

    private String inetHost;
    private int inetPort;

    public ClientSocket(String inetHost, int inetPort) {
        this.inetHost = inetHost;
        this.inetPort = inetPort;
    }

    @Override
    public void run() {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.AUTO_READ, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(
                            new RpcDecoder(Response.class),
                            new RpcEncoder(Request.class),
                            new MyClientHandler());
                }
            });
            ChannelFuture f = b.connect(inetHost, inetPort).sync();
            this.future = f;
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    public ChannelFuture getFuture() {
        return future;
    }

    public void setFuture(ChannelFuture future) {
        this.future = future;
    }
}
