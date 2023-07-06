package com.wt.learn.context;

import com.wt.learn.request.GatewayRequest;
import com.wt.learn.response.GatewayResponse;
import com.wt.learn.rule.Rule;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Author: wtt
 * @Date: 2023/7/4 22:20
 * @Version: 1.0
 * @Description:
 */
public class GateContext extends BaseContext {

    public GatewayRequest request;

    public GatewayResponse response;

    public Rule rule;


    public GateContext(String protocol, ChannelHandlerContext nettyCtx, boolean keepAlive,
                       GatewayRequest request, GatewayResponse response, Rule rule) {
        super(protocol, nettyCtx, keepAlive);
        this.request = request;
        this.response = response;
        this.rule = rule;
    }


    @lombok.Builder
    public static class Builder {
        private String protocol;
        private ChannelHandlerContext nettyCtx;
        private GatewayRequest request;
        private Rule rule;
        private boolean keepAlive;

    }
}
