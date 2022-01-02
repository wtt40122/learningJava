package com.wt.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/1/2 21:59
 */
public class NettyHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if (msg instanceof HttpRequest) {
            DefaultHttpRequest httpRequest = (DefaultHttpRequest) msg;
            System.out.println("浏览器请求路径：" + httpRequest.uri());
            if ("/favicon.ico".equals(httpRequest.uri())) {
                System.out.println("图标不响应");
                return;
            }
            ByteBuf byteBuf = Unpooled.copiedBuffer("Hello 我是netty服务器", CharsetUtil.UTF_8);
            DefaultHttpResponse httpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
            httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html;charset=utf-8");
            httpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes());
            ctx.writeAndFlush(httpResponse);
        }
    }
}
