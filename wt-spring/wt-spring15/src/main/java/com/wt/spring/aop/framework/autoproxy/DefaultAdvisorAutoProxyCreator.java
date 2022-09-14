package com.wt.spring.aop.framework.autoproxy;

import com.wt.spring.aop.*;
import com.wt.spring.aop.aspect.AspectJExpressionPointCutAdvisor;
import com.wt.spring.aop.framework.ProxyFactory;
import com.wt.spring.beans.BeansException;
import com.wt.spring.beans.PropertyValues;
import com.wt.spring.beans.factory.BeanFactory;
import com.wt.spring.beans.factory.BeanFactoryAware;
import com.wt.spring.beans.factory.config.InstantiationAwareBeanPostProcessor;
import com.wt.spring.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.Collection;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/11 12:20
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (isInfrastructureClass(beanClass)) {
            return bean;
        }
        Collection<AspectJExpressionPointCutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointCutAdvisor.class).values();
        for (AspectJExpressionPointCutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointCut().getClassFilter();
            if (!classFilter.matches(beanClass)) {
                continue;
            }
            AdvisedSupported advisedSupported = new AdvisedSupported();
            TargetSource targetSource = new TargetSource(bean);
            advisedSupported.setTargetSource(targetSource);
            advisedSupported.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupported.setMethodMatcher(advisor.getPointCut().getMethodMatcher());
            advisedSupported.setProxyTargetClass(false);
            return new ProxyFactory(advisedSupported).getProxy();
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return pvs;
    }

    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) ||
                PointCut.class.isAssignableFrom(beanClass) ||
                Advisor.class.isAssignableFrom(beanClass);
    }
}
