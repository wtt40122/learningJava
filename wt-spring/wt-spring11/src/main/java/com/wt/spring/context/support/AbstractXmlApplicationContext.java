package com.wt.spring.context.support;

import com.wt.spring.beans.factory.support.DefaultListableBeanFactory;
import com.wt.spring.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author: wtt
 * @date: 2022/9/4 17:48
 * @description:
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);

        String[] configLocations = getConfigLocations();
        if(null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
