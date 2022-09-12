package com.wt.spring.aop;

import org.aopalliance.aop.Advice;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/11 12:06
 */
public interface Advisor {

    Advice getAdvice();
}
