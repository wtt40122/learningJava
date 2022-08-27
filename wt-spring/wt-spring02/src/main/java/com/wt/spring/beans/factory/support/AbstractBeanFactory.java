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
        Object bean = getSingle(name);
        if (null != bean) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;
}
