package com.wt.netty00.nio.server;

import com.wt.netty00.nio.ChannelAdapter;
import com.wt.netty00.nio.ChannelHandler;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/3/16 10:42
 */
public class NioServerHandler extends ChannelAdapter {
    public NioServerHandler(Selector selector, Charset charset) {
        super(selector, charset);
    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息：" + msg);
        ctx.writeAndFlush("hi 我已经收到你的消息Success！\r\n");
    }

    @Override
    public void channelActive(ChannelHandler ctx) {
        try {
            System.out.println("链接报告LocalAddress:" + ctx.channel().getLocalAddress());
            ctx.writeAndFlush("hi! 我是 NioServer to msg for you \r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
