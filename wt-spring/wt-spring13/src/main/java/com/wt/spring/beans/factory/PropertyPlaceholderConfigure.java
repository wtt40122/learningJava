package com.wt.spring.beans.factory;

import com.wt.spring.beans.BeansException;
import com.wt.spring.beans.PropertyValue;
import com.wt.spring.beans.PropertyValues;
import com.wt.spring.beans.factory.config.BeanDefinition;
import com.wt.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.wt.spring.core.io.DefaultResourceLoader;
import com.wt.spring.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/12 19:03
 */
public class PropertyPlaceholderConfigure implements BeanFactoryPostProcessor {

    private static final String DEFAULT_PLACEHOLDER_PREFIX = "${";

    private static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());

            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanDefinitionName : beanDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String)) {
                        continue;
                    }
                    String strVal = (String) value;
                    StringBuilder buffer = new StringBuilder(strVal);
                    int startIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
                    int endIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
                    if (startIdx != -1 && endIdx != -1 && startIdx < endIdx) {
                        String proKey = strVal.substring(startIdx + 2, endIdx);
                        String propVal = properties.getProperty(proKey);
                        buffer.replace(startIdx, endIdx + 1, propVal);
                        propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), buffer.toString()));
                    }
                }
            }
        } catch (IOException e) {
            throw new BeansException("could not load properties", e);
        }
    }
}
