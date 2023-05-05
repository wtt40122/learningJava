package com.wt.netty21.server;

import com.wt.netty21.service.ExtServerService;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/5 9:52
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    private ExtServerService extServerService;

    public ServerChannelInitializer(ExtServerService extServerService) {
        this.extServerService = extServerService;
    }

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // 基于换行符号
        channel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        // 解码转String，注意调整自己的编码格式GBK、UTF-8
        channel.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));
        // 解码转String，注意调整自己的编码格式GBK、UTF-8
        channel.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MyServerHandler(extServerService));
    }
}
