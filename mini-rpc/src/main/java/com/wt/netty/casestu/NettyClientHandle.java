package com.wt.netty.casestu;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/1/2 12:26
 */
public class NettyClientHandle implements ChannelInboundHandler {
    @Override
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) {

    }

    @Override
    public void channelUnregistered(ChannelHandlerContext channelHandlerContext) {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush("你好呀,我是Netty客户端");
    }

    @Override
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {

    }

    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object msg) {
        System.out.println("服务端发来消息:" +msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {

    }

    @Override
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object o) {

    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) {

    }

    @Override
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) {

    }
}
