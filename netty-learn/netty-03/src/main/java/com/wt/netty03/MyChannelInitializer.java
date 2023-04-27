package com.wt.netty03;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.nio.charset.Charset;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/3/17 15:25
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //基于换行符的解码器
        ch.pipeline().addLast(new LineBasedFrameDecoder(1024));

//        ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, false, Delimiters.lineDelimiter()));
//        ch.pipeline().addLast(new FixedLengthFrameDecoder(4));

        ch.pipeline().addLast(new StringDecoder(Charset.forName("UTF-8")));
        ch.pipeline().addLast(new MyServerHandler());
    }
}
