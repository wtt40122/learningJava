package com.wt.netty22.domain.protocol;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/6 14:18
 */
public abstract class Packet {

    /**
     * 获取协议指令
     *
     * @return
     */
    public abstract Byte getCommand();
}
