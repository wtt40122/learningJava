package com.wt.learn.netty.processor;

import com.wt.learn.context.HttpRequestWrapper;

/**
 * @Author: wtt
 * @Date: 2023/7/8 12:15
 * @Version: 1.0
 * @Description:
 */
public interface NettyProcessor {

    void process(HttpRequestWrapper wrapper);
}
