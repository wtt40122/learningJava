package com.wt.netty18.server;

import com.wt.netty18.codec.ObjDecoder;
import com.wt.netty18.codec.ObjEncoder;
import com.wt.netty18.domain.TransportProtocol;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/4 12:18
 */
@Service
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Resource
    private MyServerHandler myServerHandler;

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //对象传输处理
        channel.pipeline().addLast(new ObjDecoder(TransportProtocol.class));
        channel.pipeline().addLast(new ObjEncoder(TransportProtocol.class));
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(myServerHandler);
    }
}
