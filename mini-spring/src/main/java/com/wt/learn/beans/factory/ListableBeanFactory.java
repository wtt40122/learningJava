package com.wt.learn.beans.factory;

import com.wt.learn.beans.BeansException;

import java.util.Map;

/**
 * @Author: wtt
 * @Date: 2023/12/23 17:26
 * @Version: 1.0
 * @Description:
 */
public interface ListableBeanFactory extends BeanFactory {
    boolean containsBeanDefinition(String beanName);

    int getBeanDefinitionCount();

    String[] getBeanDefinitionNames();

    String[] getBeanNamesForType(Class<?> type);

    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;
}
