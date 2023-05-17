package com.wt.netty.rpc.config.spring.bean;

import com.wt.netty.rpc.config.ConsumerConfig;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/8 9:39
 */
public class ConsumerBean<T> extends ConsumerConfig<T> implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return refer();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
