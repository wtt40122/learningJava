package com.wt.learn.beans;

/**
 * @Author: wtt
 * @Date: 2023/12/14 23:42
 * @Version: 1.0
 * @Description:
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String name, BeanDefinition beanDefinition);

    void removeBeanDefinition(String name);

    BeanDefinition getBeanDefinition(String name);

    boolean containsBeanDefinition(String name);
}
