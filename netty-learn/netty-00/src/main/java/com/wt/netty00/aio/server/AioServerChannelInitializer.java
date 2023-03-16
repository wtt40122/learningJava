package com.wt.netty00.aio.server;

import com.wt.netty00.aio.ChannelInitializer;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/3/14 11:11
 */
public class AioServerChannelInitializer extends ChannelInitializer {
    @Override
    protected void initChannel(AsynchronousSocketChannel channel) {
        channel.read(ByteBuffer.allocate(1024), 10, TimeUnit.SECONDS, null,
                new AioServerHandler(channel, Charset.forName("GBK")));
    }
}
