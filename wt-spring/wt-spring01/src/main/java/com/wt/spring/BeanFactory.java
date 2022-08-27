package com.wt.spring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wtt
 * @date: 2022/8/27 15:12
 * @description:
 */
public class BeanFactory {

    Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    public Object getBean(String beanName) {
        return beanDefinitionMap.get(beanName).getBean();
    }

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
