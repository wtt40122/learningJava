package com.wt.netty22.domain;

import com.wt.netty22.domain.protocol.Command;
import com.wt.netty22.domain.protocol.Packet;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/5 18:58
 */
public class MsgDemo02 extends Packet {

    private String channelId;
    private String demo02;

    public MsgDemo02(String channelId, String demo02) {
        this.channelId = channelId;
        this.demo02 = demo02;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getDemo02() {
        return demo02;
    }

    public void setDemo02(String demo02) {
        this.demo02 = demo02;
    }

    @Override
    public Byte getCommand() {
        return Command.Demo02;
    }
}
