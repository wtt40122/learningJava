package com.wt.spring.beans.factory.config;

import com.wt.spring.beans.BeansException;

/**
 * @author: wtt
 * @date: 2022/9/4 17:17
 * @description:
 */
public interface BeanPostProcessor {

    /**
     * 在bean对象执行初始化方法之前，执行此方法
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在bean对象执行出初始化方法之后，执行此方法
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
