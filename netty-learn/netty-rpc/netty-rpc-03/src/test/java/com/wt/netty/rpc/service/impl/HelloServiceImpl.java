package com.wt.netty.rpc.service.impl;

import com.wt.netty.rpc.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/10 10:06
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {
    @Override
    public void echo() {
        System.out.println("hi itstack demo rpc");
    }
}
