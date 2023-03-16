package com.wt.netty00.aio.server;

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
 * @date 2023/3/14 11:14
 */
public class AioServerHandler extends ChannelAdapter {

    public AioServerHandler(AsynchronousSocketChannel channel, Charset charset) {
        super(channel, charset);
    }

    @Override
    protected void channelActive(ChannelHandler ctx) {
        try {
            System.out.println(" 链接报告信息:" + ctx.channel().getRemoteAddress());
            //通知客户端链接建立成功
            ctx.writeAndFlush(" 通知服务端链接建立成功" + " " + new Date() + " " + ctx.channel().getRemoteAddress() + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void channelInactive(ChannelHandler channelHandler) {

    }

    @Override
    protected void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println("微服务端收到：" + new Date() + " " + msg + "\r\n");
        ctx.writeAndFlush("服务端信息处理Success！\r\n");
    }
}
