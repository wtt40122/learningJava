package com.wt.spring02;

import com.wt.spring.beans.factory.config.BeanDefinition;
import com.wt.spring.beans.factory.support.DefaultListableBeanFactory;
import com.wt.spring02.bean.UserService;
import org.junit.Test;

/**
 * @author: wtt
 * @date: 2022/8/27 15:16
 * @description:
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        // 执行bean
        userService.queryUserInfo();
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();

    }
}
