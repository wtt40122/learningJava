package com.wt.spring.test11.common;

import com.wt.spring.beans.BeansException;
import com.wt.spring.beans.PropertyValue;
import com.wt.spring.beans.PropertyValues;
import com.wt.spring.beans.factory.ConfigurableListableBeanFactory;
import com.wt.spring.beans.factory.config.BeanDefinition;
import com.wt.spring.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author: wtt
 * @date: 2022/9/4 19:15
 * @description:
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        if (null != beanDefinition) {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            propertyValues.addPropertyValue(new PropertyValue("company", "字节跳动"));
        }
    }
}
