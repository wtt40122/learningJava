package com.wt.netty09.server;

import com.wt.netty09.codec.MyDecoder;
import com.wt.netty09.codec.MyEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/1 11:37
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //自定义解码器
        channel.pipeline().addLast(new MyDecoder());
        //自定义编码器
        channel.pipeline().addLast(new MyEncoder());
        //在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MyClientHandler());
    }
}
