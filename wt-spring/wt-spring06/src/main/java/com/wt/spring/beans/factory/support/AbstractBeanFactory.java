package com.wt.spring.beans.factory.support;

import com.wt.spring.beans.BeansException;
import com.wt.spring.beans.factory.config.BeanDefinition;
import com.wt.spring.beans.factory.config.BeanPostProcessor;
import com.wt.spring.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wtt
 * @date: 2022/8/27 15:38
 * @description:
 */
public abstract class AbstractBeanFactory extends DefaultSingleBeanRegistry
        implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

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

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    protected abstract Object createBean(String name,
                                         BeanDefinition beanDefinition,
                                         Object[] args) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;
}
