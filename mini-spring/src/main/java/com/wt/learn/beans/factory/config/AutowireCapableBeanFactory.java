package com.wt.learn.beans.factory.config;

import com.wt.learn.beans.BeansException;
import com.wt.learn.beans.factory.BeanFactory;

/**
 * @Author: wtt
 * @Date: 2023/12/23 17:40
 * @Version: 1.0
 * @Description:
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    int AUTOWIRE_NO = 0;
    int AUTOWIRE_BY_NAME = 1;
    int AUTOWIRE_BY_TYPE = 2;

    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
            throws BeansException;

    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
            throws BeansException;
}
