package com.wt.netty22.server;

import com.wt.netty22.codec.ObjDecoder;
import com.wt.netty22.codec.ObjEncoder;
import com.wt.netty22.server.handler.MsgDemo01Handler;
import com.wt.netty22.server.handler.MsgDemo02Handler;
import com.wt.netty22.server.handler.MsgDemo03Handler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/5 18:55
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //对象传输处理[解码]
        channel.pipeline().addLast(new ObjDecoder());
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MsgDemo01Handler());
        channel.pipeline().addLast(new MsgDemo02Handler());
        channel.pipeline().addLast(new MsgDemo03Handler());
        //对象传输处理[编码]
        channel.pipeline().addLast(new ObjEncoder());
    }
}
