package com.wt.spring.beans.factory.support;

import com.wt.spring.beans.factory.config.SingleBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wtt
 * @date: 2022/8/27 15:36
 * @description:
 */
public class DefaultSingleBeanRegistry implements SingleBeanRegistry {

    private Map<String, Object> singleObjects = new HashMap<>();

    @Override
    public Object getSingle(String beanName) {
        return singleObjects.get(beanName);
    }

    protected void addSingle(String beanName, Object bean) {
        singleObjects.put(beanName, bean);
    }
}
