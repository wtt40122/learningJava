package com.wt.netty.casestu;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/1/2 18:45
 */
public class MessageDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) {
        System.out.println("正在进行消息解码");
        out.add(msg.toString(CharsetUtil.UTF_8));
    }
}
