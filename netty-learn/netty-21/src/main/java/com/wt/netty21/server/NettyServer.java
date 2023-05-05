package com.wt.netty21.server;

import com.wt.netty21.service.ExtServerService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Callable;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/5 9:46
 */
public class NettyServer implements Callable<Channel> {

    private Logger logger = LoggerFactory.getLogger(NettyServer.class);
    private final InetSocketAddress address;
    private final ExtServerService extServerService;

    private final EventLoopGroup parentGroup = new NioEventLoopGroup();
    private final EventLoopGroup childGroup = new NioEventLoopGroup();
    private Channel channel;

    public NettyServer(InetSocketAddress address, ExtServerService extServerService) {
        this.address = address;
        this.extServerService = extServerService;
    }


    @Override
    public Channel call() throws Exception {
        ChannelFuture channelFuture = null;
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(parentGroup, childGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new ServerChannelInitializer(extServerService));

            channelFuture = bootstrap.bind(address).syncUninterruptibly();
            channel = channelFuture.channel();
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            if (null != channelFuture && channelFuture.isSuccess()) {
                logger.info("netty server start done.");
            } else {
                logger.error("netty server start error.");
            }
        }
        return channel;
    }

    public void destroy() {
        if (null == channel) {
            return;
        }
        channel.close();
        parentGroup.shutdownGracefully();
        childGroup.shutdownGracefully();
    }

    public Channel getChannel() {
        return channel;
    }
}
