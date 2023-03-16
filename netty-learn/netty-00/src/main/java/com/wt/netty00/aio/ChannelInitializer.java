package com.wt.netty00.aio;

import com.wt.netty00.aio.server.AioServer;

import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/3/14 11:12
 */
public abstract class ChannelInitializer implements CompletionHandler<AsynchronousSocketChannel, AioServer> {
    @Override
    public void completed(AsynchronousSocketChannel channel, AioServer attachment) {
        try {
            initChannel(channel);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            attachment.getserverSocketChannel().accept(attachment, this);
        }
    }

    protected abstract void initChannel(AsynchronousSocketChannel channel);

    @Override
    public void failed(Throwable exc, AioServer attachment) {
        exc.printStackTrace();
    }
}
