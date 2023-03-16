package com.wt.netty00.nio;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/3/16 10:10
 */
public class ChannelHandler {

    private final SocketChannel channel;
    private final Charset charset;

    public ChannelHandler(SocketChannel channel, Charset charset) {
        this.channel = channel;
        this.charset = charset;
    }

    public void writeAndFlush(Object msg) {
        try {
            byte[] bytes = msg.toString().getBytes(charset);
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SocketChannel channel() {
        return channel;
    }
}
