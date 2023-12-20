package com.wt.learn.beans.factory.config;

import com.wt.learn.beans.BeansException;

/**
 * @Author: wtt
 * @Date: 2023/12/20 17:38
 * @Version: 1.0
 * @Description:
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
