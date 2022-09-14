package com.wt.spring.test14;

import com.wt.spring.aop.AdvisedSupported;
import com.wt.spring.aop.TargetSource;
import com.wt.spring.aop.aspect.AspectJExpressionPointCut;
import com.wt.spring.aop.framework.Cglib2AopProxy;
import com.wt.spring.aop.framework.JdkDynamicAopProxy;
import com.wt.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.wt.spring.beans.factory.config.BeanPostProcessor;
import com.wt.spring.beans.factory.support.DefaultListableBeanFactory;
import com.wt.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.wt.spring.context.support.ClassPathXmlApplicationContext;
import com.wt.spring.test14.bean.*;
import com.wt.spring.test14.common.MyBeanFactoryPostProcessor;
import com.wt.spring.test14.common.MyBeanPostProcessor;
import com.wt.spring.test14.event.CustomEvent;
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
    public void test_dynamic() {
        IBookService bookService = new BookService();
        AdvisedSupported advisedSupported = new AdvisedSupported();
        advisedSupported.setTargetSource(new TargetSource(bookService));
        advisedSupported.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupported.setMethodMatcher(new AspectJExpressionPointCut("execution(* com.wt.spring.test12.bean.UserService.*(..))"));

        IBookService proxy_jdk = (IBookService) new JdkDynamicAopProxy(advisedSupported).getProxy();
        System.out.println("测试结果:" + proxy_jdk.queryBookInfo());

        IBookService proxy_cglib = (IBookService) new Cglib2AopProxy(advisedSupported).getProxy();
        System.out.println("测试结果:" + proxy_cglib.register("菜菜"));
    }

    @Test
    public void test_aop() {
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("classpath:spring.xml");
        IBookService bookService = applicationContext.getBean("bookService", IBookService.class);
        System.out.println("测试结果：" + bookService.queryBookInfo());
    }

    @Test
    public void test_property() {
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("classpath:spring-property.xml");
        ISchoolService schoolService = applicationContext.getBean("schoolService", ISchoolService.class);
        System.out.println("测试结果:" + schoolService);
    }

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        ISchoolService schoolService = applicationContext.getBean("schoolService", ISchoolService.class);
        System.out.println("测试结果：" + schoolService.queryUserInfo());
    }

    @Test
    public void test_annotation() {
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("classpath:spring-annotation.xml");
        ISchoolService schoolService = applicationContext.getBean("schoolService", ISchoolService.class);
        System.out.println("测试结果：" + schoolService.queryUserInfo());
    }

    @Test
    public void test_hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close")));
    }
}
