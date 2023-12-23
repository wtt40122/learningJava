package com.wt.learn.beans.factory.support;

import com.wt.learn.beans.BeansException;
import com.wt.learn.beans.factory.config.AbstractAutowireCapableBeanFactory;
import com.wt.learn.beans.factory.config.BeanDefinition;
import com.wt.learn.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wtt
 * @Date: 2023/12/23 17:50
 * @Version: 1.0
 * @Description:
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements
        ConfigurableListableBeanFactory {
    @Override
    public int getBeanDefinitionCount() {
        return this.beanDefinitionMap.size();
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return (String[]) this.beanDefinitionNames.toArray();
    }

    @Override
    public String[] getBeanNamesForType(Class<?> type) {
        List<String> result = new ArrayList<>();
        for (String beanName : this.beanDefinitionNames) {
            BeanDefinition mbd = this.getBeanDefinition(beanName);
            Class<?> beanClass = mbd.getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                result.add(beanName);
            }
        }
        return result.toArray(new String[0]);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        String[] beanNames = this.getBeanNamesForType(type);
        Map<String, T> result = new LinkedHashMap<>();
        for (String beanName : beanNames) {
            Object beanInstance = this.getBean(beanName);
            if (null != beanInstance) {
                result.put(beanName, (T) beanInstance);
            }
        }
        return result;
    }

}
