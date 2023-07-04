package com.wt.learn.context;

import io.netty.channel.ChannelHandlerContext;

/**
 * @Author: wtt
 * @Date: 2023/7/4 22:20
 * @Version: 1.0
 * @Description:
 */
public class GateContext extends BaseContext {

//    public GatewayRequest request;
//
//    public GatewayResponse response;
//
//    public Rule rule;


    public GateContext(String protocol, ChannelHandlerContext nettyCtx, boolean keepAlive) {
        super(protocol, nettyCtx, keepAlive);
    }
}
