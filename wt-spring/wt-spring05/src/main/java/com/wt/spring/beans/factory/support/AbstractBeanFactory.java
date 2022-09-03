package com.wt.spring.beans.factory.support;

import com.wt.spring.beans.BeansException;
import com.wt.spring.beans.factory.BeanFactory;
import com.wt.spring.beans.factory.config.BeanDefinition;

/**
 * @author: wtt
 * @date: 2022/8/27 15:38
 * @description:
 */
public abstract class AbstractBeanFactory extends DefaultSingleBeanRegistry
        implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }


    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requireType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingle(name);
        if (null != bean) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract Object createBean(String name,
                                         BeanDefinition beanDefinition,
                                         Object[] args) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;
}
