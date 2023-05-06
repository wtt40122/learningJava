package com.wt.netty22.codec;

import com.wt.netty22.domain.protocol.Packet;
import com.wt.netty22.util.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/6 14:27
 */
public class ObjEncoder extends MessageToByteEncoder<Packet> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet msg, ByteBuf out) throws Exception {
        byte[] data = SerializationUtil.serialize(msg);
        out.writeInt(data.length + 1);
        out.writeByte(msg.getCommand()); //添加指令
        out.writeBytes(data);
    }
}
