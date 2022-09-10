package com.wt.spring.test11;

import com.wt.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.wt.spring.beans.factory.config.BeanPostProcessor;
import com.wt.spring.beans.factory.support.DefaultListableBeanFactory;
import com.wt.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.wt.spring.context.support.ClassPathXmlApplicationContext;
import com.wt.spring.test11.bean.UserService;
import com.wt.spring.test11.common.MyBeanFactoryPostProcessor;
import com.wt.spring.test11.common.MyBeanPostProcessor;
import com.wt.spring.test11.event.CustomEvent;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

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
    public void test_xml_aware() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("result:" + result);
        System.out.println("applicationContextAware:" + userService.getApplicationContext());
        System.out.println("beanFactoryAware:" + userService.getBeanFactory());
    }

    @Test
    public void test_prototype() {
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        System.out.println(userService01);
        System.out.println(userService02);

        // 打印16进制hash
        System.out.println(userService01 + " 十六进制哈希:" + Integer.toHexString(userService01.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());
    }

    @Test
    public void test_factory_bean() {
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("result:" + userService.queryUserInfo());
    }

    @Test
    public void test_event() throws InterruptedException {
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1232424324234L, "我成功了"));
        applicationContext.registerShutdownHook();
        TimeUnit.MINUTES.sleep(1l);
        applicationContext.publishEvent(new CustomEvent(applicationContext, 325435L, "我又来了"));
    }


    @Test
    public void test_hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close")));
    }
}
