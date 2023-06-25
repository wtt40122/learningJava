package com.wt.spring.beans.factory.support;

import com.wt.spring.beans.BeansException;
import com.wt.spring.beans.factory.config.BeanDefinition;

/**
 * @author: wtt
 * @date: 2022/8/27 15:46
 * @description:
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingle(name, bean);
        return bean;
    }
}
