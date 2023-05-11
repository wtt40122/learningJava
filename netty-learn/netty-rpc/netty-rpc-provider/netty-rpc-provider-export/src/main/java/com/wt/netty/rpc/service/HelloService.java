package com.wt.netty.rpc.service;

import com.wt.netty.rpc.domain.Hi;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/11 10:21
 */
public interface HelloService {
    String hi();

    String say(String str);

    String sayHi(Hi hi);
}
