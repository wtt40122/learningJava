package com.wt.netty.rpc;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/1/3 23:01
 */
public class RpcClient {
    private EventLoopGroup group;
    private Channel channel;
    private String ip;
    private int port;
    private RpcClientHandler rpcClientHandler = new RpcClientHandler();
    private ExecutorService executorService = Executors.newCachedThreadPool();

    public RpcClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
        initClient();
    }

    public void initClient() {
        try {
            //1.创建线程组
            group = new NioEventLoopGroup();
            //2.创建启动助手
            Bootstrap bootstrap = new Bootstrap();
            //3.设置参数
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 9799)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                            //String类型编解码器
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new StringEncoder());
                            //添加客户端处理类
                            pipeline.addLast(rpcClientHandler);
                        }
                    });
            //4.连接Netty服务端
            channel = bootstrap.connect(ip, port).sync().channel();
        } catch (Exception exception) {
            exception.printStackTrace();
            if (channel != null) {
                channel.close();
            }
            if (group != null) {
                group.shutdownGracefully();
            }
        }
    }

    public Object send(String msg) throws ExecutionException, InterruptedException {
        rpcClientHandler.setRequestMsg(msg);
        Future submit = executorService.submit(rpcClientHandler);
        return submit.get();
    }

    public void close() {
        if (channel != null) {
            channel.close();
        }
        if (group != null) {
            group.shutdownGracefully();
        }
    }
}
