package com.wt.spring01;

import com.wt.spring.BeanDefinition;
import com.wt.spring.BeanFactory;
import com.wt.spring01.bean.UserService;
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
        BeanFactory beanFactory = new BeanFactory();
        // 注册bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        // 执行bean
        userService.queryUserInfo();
    }
}
