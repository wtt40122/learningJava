package com.wt.learn.context;

import com.wt.learn.beans.BeanFactory;
import com.wt.learn.beans.BeansException;
import com.wt.learn.beans.SimpleBeanFactory;
import com.wt.learn.beans.XmlBeanDefinitionReader;
import com.wt.learn.core.ClassPathXmlResource;
import com.wt.learn.core.Resource;

/**
 * @Author: wtt
 * @Date: 2023/12/13 23:57
 * @Version: 1.0
 * @Description:
 */
public class ClassPathXmlApplicationContext implements BeanFactory, ApplicationEventPublisher {

    private SimpleBeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName) {
        this(fileName, true);
    }

    public ClassPathXmlApplicationContext(String fileName, Boolean isRefresh) {
        Resource resource = new ClassPathXmlResource(fileName);
        beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        if (isRefresh) {
            beanFactory.refresh();
        }
    }


    @Override
    public Object getBean(String beanName) throws BeansException {
        return beanFactory.getBean(beanName);
    }

    @Override
    public boolean containsBean(String name) {
        return beanFactory.containsBean(name);
    }

    @Override
    public boolean isSingleton(String name) {
        return false;
    }

    @Override
    public boolean isPrototype(String name) {
        return false;
    }

    @Override
    public Class<?> getType(String name) {
        return null;
    }


    @Override
    public void publishEvent(ApplicationEvent event) {

    }
}
