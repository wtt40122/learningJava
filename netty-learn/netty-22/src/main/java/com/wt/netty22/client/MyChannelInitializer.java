package com.wt.netty22.client;

import com.wt.netty22.codec.ObjDecoder;
import com.wt.netty22.codec.ObjEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/6 14:31
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //对象传输处理
        channel.pipeline().addLast(new ObjDecoder());
        channel.pipeline().addLast(new ObjEncoder());
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MyClientHandler());
    }
}
