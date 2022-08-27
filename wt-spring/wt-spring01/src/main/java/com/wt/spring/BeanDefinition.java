package com.wt.spring;

/**
 * @author: wtt
 * @date: 2022/8/27 15:10
 * @description:
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
