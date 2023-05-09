package com.wt.netty.rpc.server;

import com.wt.netty.rpc.msg.Request;
import com.wt.netty.rpc.msg.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/9 9:36
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object obj) {
        Request msg = (Request) obj;
        //反馈
        Response request = new Response();
        request.setRequestId(msg.getRequestId());
        request.setParam(msg.getResult() + " 请求成功，反馈结果请接受处理。");
        ctx.writeAndFlush(request);
        //释放
        ReferenceCountUtil.release(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }
}
