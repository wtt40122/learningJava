package com.wt.netty24.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @Author: wtt
 * @Date: 2023/5/7 16:51
 * @Description:
 */
public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("NettyClient接收到消息：" + msg + " length：" + msg.length());
        ctx.write(UUID.randomUUID().toString() + "\r\n", ctx.voidPromise());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.channel().close();
    }

}
