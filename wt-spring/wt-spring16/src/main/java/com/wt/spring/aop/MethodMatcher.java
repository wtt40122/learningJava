package com.wt.spring.aop;

import java.lang.reflect.Method;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/10 16:53
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
