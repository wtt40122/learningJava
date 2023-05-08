package com.wt.netty.rpc.config.spring.bean;

import com.wt.netty.rpc.config.ServerConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/8 9:40
 */
public class ServerBean extends ServerConfig implements InitializingBean, ApplicationContextAware {

    private transient ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.format("服务端信息=> [注册中心地址：%s] [注册中心端口：%s] \r\n", host, port);
    }
}
