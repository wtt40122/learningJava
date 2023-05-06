package com.wt.netty22.domain.protocol;

import com.wt.netty22.domain.MsgDemo01;
import com.wt.netty22.domain.MsgDemo02;
import com.wt.netty22.domain.MsgDemo03;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/6 14:20
 */
public class PacketClazzMap {

    public final static Map<Byte, Class<? extends Packet>> packetTypeMap = new ConcurrentHashMap<>();

    static {
        packetTypeMap.put(Command.Demo01, MsgDemo01.class);
        packetTypeMap.put(Command.Demo02, MsgDemo02.class);
        packetTypeMap.put(Command.Demo03, MsgDemo03.class);
    }
}
