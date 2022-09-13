package com.wt.spring.beans.factory.support;

import com.wt.spring.beans.BeansException;
import com.wt.spring.beans.factory.DisposableBean;
import com.wt.spring.beans.factory.config.SingleBeanRegistry;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: wtt
 * @date: 2022/8/27 15:36
 * @description:
 */
public class DefaultSingleBeanRegistry implements SingleBeanRegistry {

    protected static final Object NULL_OBJECT = new Object();

    private Map<String, Object> singleObjects = new ConcurrentHashMap<>();
    private final Map<String, DisposableBean> disposableBeans = new LinkedHashMap<>();

    @Override
    public Object getSingle(String beanName) {
        return singleObjects.get(beanName);
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singleObjects.put(beanName, singletonObject);
    }

    protected void addSingle(String beanName, Object beanDefinition) {
        singleObjects.put(beanName, beanDefinition);
    }

    public void registerDisposableBean(String beanName, DisposableBean disposableBean) {
        disposableBeans.put(beanName, disposableBean);
    }

    public void destroySingletons() {
        Set<String> keySet = disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();
        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}
