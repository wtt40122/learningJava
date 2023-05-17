package com.wt.netty.rpc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/10 10:05
 */
public class ApiTest {
    public static void main(String[] args) {
        String[] configs = {"wtt-rpc-center.xml", "wtt-rpc-provider.xml", "wtt-rpc-consumer.xml"};
        new ClassPathXmlApplicationContext(configs);
    }
}
