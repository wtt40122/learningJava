package com.wt.spring.beans.factory.config;

/**
 * @author: wtt
 * @date: 2022/8/27 15:34
 * @description:
 */
public interface SingleBeanRegistry {

    Object getSingle(String beanName);
}
