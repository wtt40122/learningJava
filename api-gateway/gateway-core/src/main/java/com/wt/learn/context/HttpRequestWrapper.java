package com.wt.learn.context;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import lombok.Data;

/**
 * @Author: wtt
 * @Date: 2023/7/8 12:03
 * @Version: 1.0
 * @Description:
 */
@Data
public class HttpRequestWrapper {

    private FullHttpRequest request;

    private ChannelHandlerContext ctx;


}
