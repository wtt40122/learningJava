package com.wt.spring.beans.factory.config;

import com.wt.spring.beans.BeansException;
import com.wt.spring.beans.factory.BeanFactory;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/3 17:14
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization方法
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行BeanPostProcessor 接口实现类的 postProcessAfterInitialization方法
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
