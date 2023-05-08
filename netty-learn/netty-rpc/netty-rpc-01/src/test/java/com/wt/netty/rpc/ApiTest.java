package com.wt.netty.rpc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/8 9:49
 */
public class ApiTest {
    public static void main(String[] args) {
        String[] configs = {"wtt-rpc-consumer.xml", "wtt-rpc-provider.xml"};
        new ClassPathXmlApplicationContext(configs);
    }
}
