package com.wt.netty.casestu;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/1/2 18:53
 */
public class MessageEncoder extends MessageToMessageEncoder<String> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, String msg, List<Object> list) throws Exception {
        System.out.println("正在进行消息编码ing");
        list.add(Unpooled.copiedBuffer(msg, CharsetUtil.UTF_8));
    }
}
