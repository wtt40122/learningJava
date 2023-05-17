package com.wt.netty.rpc.impl;

import com.wt.netty.rpc.HelloService;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/8 9:49
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void echo() {
        System.out.println("hi netty demo rpc");
    }
}
