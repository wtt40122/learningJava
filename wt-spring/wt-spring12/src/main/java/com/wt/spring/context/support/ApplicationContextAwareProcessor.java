package com.wt.spring.context.support;

import com.wt.spring.beans.BeansException;
import com.wt.spring.beans.factory.config.BeanPostProcessor;
import com.wt.spring.context.ApplicationContext;
import com.wt.spring.context.ApplicationContextAware;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/8 20:31
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessorAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
