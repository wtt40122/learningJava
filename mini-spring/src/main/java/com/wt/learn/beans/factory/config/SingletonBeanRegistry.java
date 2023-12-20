package com.wt.learn.beans.factory.config;

/**
 * @Author: wtt
 * @Date: 2023/12/14 22:40
 * @Version: 1.0
 * @Description:
 */
public interface SingletonBeanRegistry {

    void registerSingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);

    boolean containsSingleton(String beanName);

    String[] getSingletonNames();
}
