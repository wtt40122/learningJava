package com.wt.learn.beans.factory.config;

import com.wt.learn.beans.BeansException;
import com.wt.learn.beans.factory.BeanFactory;

/**
 * @Author: wtt
 * @Date: 2023/12/20 18:04
 * @Version: 1.0
 * @Description:
 */
public interface BeanFactoryPostProcessor {
    void postProcessBeanFactory(BeanFactory beanFactory) throws BeansException;

}
