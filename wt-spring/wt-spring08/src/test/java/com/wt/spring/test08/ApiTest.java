package com.wt.spring.test08;

import com.wt.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.wt.spring.beans.factory.config.BeanPostProcessor;
import com.wt.spring.beans.factory.support.DefaultListableBeanFactory;
import com.wt.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.wt.spring.context.support.ClassPathXmlApplicationContext;
import com.wt.spring.test08.bean.UserService;
import com.wt.spring.test08.common.MyBeanFactoryPostProcessor;
import com.wt.spring.test08.common.MyBeanPostProcessor;
import org.junit.Test;

/**
 * @author: wtt
 * @date: 2022/9/4 19:11
 * @description:
 */
public class ApiTest {

    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

//        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");
        BeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        BeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);

    }

    @Test
    public void test_xml() {
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("classpath:spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_xml_new() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("result:" + userService.queryUserInfo());
    }


    @Test
    public void test_hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close")));
    }
}
