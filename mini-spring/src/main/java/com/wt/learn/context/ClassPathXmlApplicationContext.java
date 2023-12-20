package com.wt.learn.context;

import com.wt.learn.beans.BeansException;
import com.wt.learn.beans.factory.BeanFactory;
import com.wt.learn.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import com.wt.learn.beans.factory.config.AutowireCapableBeanFactory;
import com.wt.learn.beans.factory.config.BeanFactoryPostProcessor;
import com.wt.learn.beans.factory.xml.XmlBeanDefinitionReader;
import com.wt.learn.core.ClassPathXmlResource;
import com.wt.learn.core.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wtt
 * @Date: 2023/12/13 23:57
 * @Version: 1.0
 * @Description:
 */
public class ClassPathXmlApplicationContext implements BeanFactory, ApplicationEventPublisher {

    private AutowireCapableBeanFactory beanFactory;
    private final List<BeanFactoryPostProcessor> beanFactoryPostProcessors =
            new ArrayList<BeanFactoryPostProcessor>();

    public ClassPathXmlApplicationContext(String fileName) {
        this(fileName, true);
    }

    public ClassPathXmlApplicationContext(String fileName, Boolean isRefresh) {
        Resource resource = new ClassPathXmlResource(fileName);
        beanFactory = new AutowireCapableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        if (isRefresh) {
            try {
                refresh();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (BeansException e) {
                e.printStackTrace();
            }
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

    public List<BeanFactoryPostProcessor> getBeanFactoryPostProcessors() {
        return this.beanFactoryPostProcessors;
    }

    public void addBeanFactoryPostProcessor(BeanFactoryPostProcessor postProcessor) {
        this.beanFactoryPostProcessors.add(postProcessor);
    }

    public void refresh() throws BeansException, IllegalStateException {
        // Register bean processors that intercept bean creation.
        registerBeanPostProcessors(this.beanFactory);

        // Initialize other special beans in specific context subclasses.
        onRefresh();
    }

    private void registerBeanPostProcessors(AutowireCapableBeanFactory bf) {
        //if (supportAutowire) {
        bf.addBeanPostProcessor(new AutowiredAnnotationBeanPostProcessor());
        //}
    }

    private void onRefresh() {
        this.beanFactory.refresh();
    }
}
