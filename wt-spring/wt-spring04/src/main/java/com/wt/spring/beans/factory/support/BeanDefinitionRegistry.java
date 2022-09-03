package com.wt.spring.beans.factory.support;

import com.wt.spring.beans.factory.config.BeanDefinition;

/**
 * @author: wtt
 * @date: 2022/8/27 15:52
 * @description:
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
