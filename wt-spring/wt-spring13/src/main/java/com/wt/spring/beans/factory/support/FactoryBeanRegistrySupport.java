package com.wt.spring.beans.factory.support;

import com.wt.spring.beans.BeansException;
import com.wt.spring.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/9 11:37
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingleBeanRegistry {

    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();


    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object result = factoryBeanObjectCache.get(beanName);
        return result != NULL_OBJECT ? result : null;
    }

    protected Object getObjectFromFactoryBean(FactoryBean factoryBean, String beanName) {
        if (factoryBean.isSingleton()) {
            Object object = this.getCachedObjectForFactoryBean(beanName);
            if (null == object) {
                object = doGetObjectFromFactoryBean(factoryBean, beanName);
                Object result = object != null ? object : NULL_OBJECT;
                factoryBeanObjectCache.put(beanName, result);
                return result;
            }
            return object != null ? object : null;
        }
        return doGetObjectFromFactoryBean(factoryBean, beanName);
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factoryBean, final String beanName) {
        try {
            return factoryBean.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean throw exception of object[" + beanName + "] creation", e);
        }
    }

}
