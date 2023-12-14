package com.wt.lean;

import com.wt.learn.beans.BeansException;
import com.wt.learn.context.ClassPathXmlApplicationContext;

/**
 * @Author: wtt
 * @Date: 2023/12/14 0:15
 * @Version: 1.0
 * @Description:
 */
public class Test1 {

    public static void main(String[] args) throws BeansException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        AService aService = (AService) applicationContext.getBean("aService");
        aService.sayHello();
    }
}
