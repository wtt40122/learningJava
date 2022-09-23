package com.wt.spring.context.support;

import com.wt.spring.beans.BeansException;
import com.wt.spring.beans.factory.ConfigurableListableBeanFactory;
import com.wt.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.wt.spring.beans.factory.config.BeanPostProcessor;
import com.wt.spring.context.ApplicationEvent;
import com.wt.spring.context.ApplicationListener;
import com.wt.spring.context.ConfigurableApplicationContext;
import com.wt.spring.context.event.*;
import com.wt.spring.core.ConversionService;
import com.wt.spring.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * @author: wtt
 * @date: 2022/9/4 17:26
 * @description:
 */
public abstract class AbstractApplicationContext extends
        DefaultResourceLoader implements ConfigurableApplicationContext {

    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void refresh() throws BeansException {
        // 1.创建beanFactory,并加载beanDefinition
        refreshBeanFactory();
        // 2.获取beanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        //3.添加ApplicationContextAwareProcessor,
        // 让继承自 ApplicationContextAware的Bean对象能感知到所属的ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
        // 4. 在实例化bean之前，执行BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);
        // 5.BeanPostProcessor 需要提前与其它bean对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);
        // 6.初始化事件发布者
        initApplicationEventMulticaster();
        // 7.注册事件监听者
        registerListeners();
        // 8. 设置类型转换器、提前实例化单例Bean对象
        finishBeanFactoryInitialization(beanFactory);
        // 9.发布容器刷新完成事件
        finishRefresh();
    }

    // 设置类型转换器、提前实例化单例Bean对象
    protected void finishBeanFactoryInitialization(ConfigurableListableBeanFactory beanFactory) {
        // 设置类型转换器
        if (beanFactory.containsBean("conversionService")) {
            Object conversionService = beanFactory.getBean("conversionService");
            if (conversionService instanceof ConversionService) {
                beanFactory.setConversionService((ConversionService) conversionService);
            }
        }

        // 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
        publishEvent(new ApplicationContextEvent(this));
    }

    private void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener applicationListener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(applicationListener);
        }
    }

    private void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }


    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        //发布容器关闭事件
        publishEvent(new ContextClosedEvent(this));
        //销毁单例bean
        getBeanFactory().destroySingletons();
    }

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    protected abstract void refreshBeanFactory() throws BeansException;

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requireType) throws BeansException {
        return getBeanFactory().getBean(name, requireType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(requiredType);
    }

    @Override
    public boolean containsBean(String name) {
        return getBeanFactory().containsBean(name);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }
}
