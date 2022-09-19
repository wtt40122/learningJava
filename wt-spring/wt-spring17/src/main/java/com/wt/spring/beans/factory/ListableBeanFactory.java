package com.wt.spring.beans.factory;

import com.wt.spring.beans.BeansException;

import java.util.Map;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/3 17:15
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回 Bean 实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     * <p>
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
