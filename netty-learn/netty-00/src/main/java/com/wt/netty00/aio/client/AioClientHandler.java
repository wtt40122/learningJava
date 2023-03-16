package com.wt.netty00.aio.client;

import com.wt.netty00.aio.ChannelAdapter;
import com.wt.netty00.aio.ChannelHandler;

import java.io.IOException;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/3/14 11:20
 */
public class AioClientHandler extends ChannelAdapter {
    public AioClientHandler(AsynchronousSocketChannel channel, Charset charset) {
        super(channel, charset);
    }

    @Override
    protected void channelActive(ChannelHandler ctx) {
        try {
            System.out.println(" 链接报告信息:" + ctx.channel().getRemoteAddress());
            //通知客户端链接建立成功
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void channelInactive(ChannelHandler channelHandler) {

    }

    @Override
    protected void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println(" 服务端收到：" + new Date() + " " + msg + "\r\n");
        ctx.writeAndFlush("客户端信息处理Success！\r\n");
    }
}
