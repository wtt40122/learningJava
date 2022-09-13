package com.wt.spring.beans.factory.config;

import com.wt.spring.beans.BeansException;
import com.wt.spring.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author: wtt
 * @date: 2022/9/4 17:14
 * @description:
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的BeanDefinition加载完成后，实例化bean对象之前，提供修改 BeanDefinition属性的机制
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
