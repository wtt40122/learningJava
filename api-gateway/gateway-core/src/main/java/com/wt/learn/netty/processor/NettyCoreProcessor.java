package com.wt.learn.netty.processor;

import com.wt.learn.context.HttpRequestWrapper;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @Author: wtt
 * @Date: 2023/7/8 12:19
 * @Version: 1.0
 * @Description:
 */
public class NettyCoreProcessor implements NettyProcessor {
    @Override
    public void process(HttpRequestWrapper wrapper) {
        ChannelHandlerContext ctx = wrapper.getCtx();
        FullHttpRequest request = wrapper.getRequest();

        
    }
}
