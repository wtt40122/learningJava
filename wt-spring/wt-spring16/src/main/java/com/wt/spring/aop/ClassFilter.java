package com.wt.spring.aop;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/10 16:52
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
