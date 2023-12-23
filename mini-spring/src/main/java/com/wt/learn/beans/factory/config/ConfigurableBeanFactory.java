package com.wt.learn.beans.factory.config;

import com.wt.learn.beans.factory.BeanFactory;

/**
 * @Author: wtt
 * @Date: 2023/12/23 17:30
 * @Version: 1.0
 * @Description:
 */
public interface ConfigurableBeanFactory extends BeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    int getBeanPostProcessorCount();

    void registerDependentBean(String beanName,String dependentBeanName);

    String[] getDependentBeans(String beanName);

    String[] getDependenciesForBean(String beanName);
}
