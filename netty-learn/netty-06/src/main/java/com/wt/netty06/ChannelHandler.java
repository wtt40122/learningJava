package com.wt.netty06;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/1 11:12
 */
public class ChannelHandler {

    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
