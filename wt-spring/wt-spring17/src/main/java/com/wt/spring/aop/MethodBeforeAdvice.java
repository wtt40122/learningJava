package com.wt.spring.aop;

import java.lang.reflect.Method;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/11 12:03
 */
public interface MethodBeforeAdvice extends BeforeAdvice {

    void before(Method method, Object[] args, Object target) throws Throwable;
}
