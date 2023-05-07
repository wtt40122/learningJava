package com.wt.netty24.server;

import com.wt.netty24.server.common.MyServerCommonHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelProgressiveFuture;

import java.util.function.Consumer;

/**
 * @Author: wtt
 * @Date: 2023/5/7 16:43
 * @Description:
 */
public class MyServerHandler extends MyServerCommonHandler {
    @Override
    protected void sendData(ChannelHandlerContext ctx) {
        sentFlag = true;
        ctx.writeAndFlush("111111111122222222223333333333\r\n", getChannelProgressivePromise(ctx, new Consumer<ChannelProgressiveFuture>() {
            @Override
            public void accept(ChannelProgressiveFuture channelProgressiveFuture) {
                if (ctx.channel().isWritable() && !sentFlag) {
                    sendData(ctx);
                }
            }
        }));
    }
}
