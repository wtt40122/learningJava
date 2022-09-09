package com.wt.spring.beans.factory;

import com.wt.spring.beans.BeansException;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/8 17:15
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
