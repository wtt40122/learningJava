package com.wt.spring.beans.factory.config;

/**
 * @author: wtt
 * @date: 2022/8/27 15:10
 * @description:
 */
public class BeanDefinition {

    private Class beanClass;

    public Class getBeanClass() {
        return beanClass;
    }

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
