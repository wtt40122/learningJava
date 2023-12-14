package com.wt.learn.netty;

import com.wt.learn.context.HttpRequestWrapper;
import com.wt.learn.netty.processor.NettyProcessor;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @Author: wtt
 * @Date: 2023/7/8 11:57
 * @Version: 1.0
 * @Description:
 */
public class NettyHttpHandler extends ChannelInboundHandlerAdapter {

    public final NettyProcessor nettyProcessor;

    public NettyHttpHandler(NettyProcessor nettyProcessor) {
        this.nettyProcessor = nettyProcessor;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        FullHttpRequest httpRequest = (FullHttpRequest) msg;

        HttpRequestWrapper wrapper = new HttpRequestWrapper();
        wrapper.setCtx(ctx);
        wrapper.setRequest(httpRequest);

        nettyProcessor.process(wrapper);
    }
}
