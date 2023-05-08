package com.wt.netty.rpc.config;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/8 9:28
 */
public class ConsumerConfig<T> {
    private String nozzle; //接口
    private String alias;  //别名

    //动态代理链接
    protected synchronized T refer() {

        System.out.format("消费者信息=> [接口：%s] [别名：%s] \r\n", nozzle, alias);

        return null;
    }

}
