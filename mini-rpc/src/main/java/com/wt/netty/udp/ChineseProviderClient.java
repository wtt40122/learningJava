package com.wt.netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/1/24 19:35
 */
public class ChineseProviderClient {

    public void run(int port) {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new ChineseProviderClientHandler());
            Channel channel = bootstrap.bind(0).sync().channel();
            channel.writeAndFlush(
                    new DatagramPacket(Unpooled.copiedBuffer("谚语字典查询?", CharsetUtil.UTF_8),
                            new InetSocketAddress("255.255.255.255", port)))
                    .sync();
            if (!channel.closeFuture().await(15000)) {
                System.out.println("查询超时！");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new ChineseProviderClient().run(8080);
    }
}
