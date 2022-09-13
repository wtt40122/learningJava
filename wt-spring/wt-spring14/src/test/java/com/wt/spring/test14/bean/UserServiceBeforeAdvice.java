package com.wt.spring.test14.bean;

import com.wt.spring.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/11 12:37
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());

    }
}
