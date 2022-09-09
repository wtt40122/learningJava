package com.wt.spring.context.support;

import com.wt.spring.beans.BeansException;
import com.wt.spring.beans.factory.ConfigurableListableBeanFactory;
import com.wt.spring.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author: wtt
 * @date: 2022/9/4 17:42
 * @description:
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}