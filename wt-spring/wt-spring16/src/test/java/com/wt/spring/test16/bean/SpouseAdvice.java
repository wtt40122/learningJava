package com.wt.spring.test16.bean;

import com.wt.spring.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/16 17:04
 */
public class SpouseAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("关怀小两口(切面)：" + method);
    }
}
