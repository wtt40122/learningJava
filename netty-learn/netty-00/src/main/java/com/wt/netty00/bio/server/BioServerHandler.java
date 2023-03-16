package com.wt.netty00.bio.server;

import com.wt.netty00.bio.ChannelAdapter;
import com.wt.netty00.bio.ChannelHandler;

import java.net.Socket;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/3/14 10:41
 */
public class BioServerHandler extends ChannelAdapter {

    public BioServerHandler(Socket socket, Charset charset) {
        super(socket, charset);
    }

    @Override
    protected void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +
                " 接收到消息：" + msg);
        ctx.writeAndFlush("hi 我已经收到你的消息Success！\r\n");
    }

    @Override
    protected void channelActive(ChannelHandler ctx) {
        System.out.println("链接报告LocalAddress:" + ctx.socket().getLocalAddress());
        ctx.writeAndFlush("hi! 我是wtt BioServer to msg for you \\r\\n");
    }
}
