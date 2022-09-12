package com.wt.spring.beans.factory.support;

import com.wt.spring.beans.BeansException;
import com.wt.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author: wtt
 * @date: 2022/8/28 14:45
 * @description:
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName,
                       Constructor ctor, Object[] args) throws BeansException;
}
