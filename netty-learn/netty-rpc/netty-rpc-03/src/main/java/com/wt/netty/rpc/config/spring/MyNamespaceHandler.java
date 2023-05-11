package com.wt.netty.rpc.config.spring;

import com.wt.netty.rpc.config.spring.bean.ConsumerBean;
import com.wt.netty.rpc.config.spring.bean.ProviderBean;
import com.wt.netty.rpc.config.spring.bean.ServerBean;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/10 9:37
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("consumer", new MyBeanDefinitionParser(ConsumerBean.class));
        registerBeanDefinitionParser("provider", new MyBeanDefinitionParser(ProviderBean.class));
        registerBeanDefinitionParser("server", new MyBeanDefinitionParser(ServerBean.class));
    }
}
