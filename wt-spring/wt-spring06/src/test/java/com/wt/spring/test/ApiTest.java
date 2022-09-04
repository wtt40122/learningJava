package com.wt.spring.test;

import com.wt.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.wt.spring.beans.factory.config.BeanPostProcessor;
import com.wt.spring.beans.factory.support.DefaultListableBeanFactory;
import com.wt.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.wt.spring.context.support.ClassPathXmlApplicationContext;
import com.wt.spring.test.bean.UserService;
import com.wt.spring.test.common.MyBeanFactoryPostProcessor;
import com.wt.spring.test.common.MyBeanPostProcessor;
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
        beanDefinitionReader.loadBeanDefinitions("classpath:springPostProcessor.xml");
//        BeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
//        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
//
//        BeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
//        beanFactory.addBeanPostProcessor(beanPostProcessor);

        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);

    }

    @Test
    public void test_xml() {
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
