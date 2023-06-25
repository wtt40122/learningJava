package com.wt.spring.beans.factory;

import com.wt.spring.beans.BeansException;
import com.wt.spring.beans.factory.config.AutowireCapableBeanFactory;
import com.wt.spring.beans.factory.config.BeanDefinition;
import com.wt.spring.beans.factory.config.BeanPostProcessor;
import com.wt.spring.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/3 17:19
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons();

}
