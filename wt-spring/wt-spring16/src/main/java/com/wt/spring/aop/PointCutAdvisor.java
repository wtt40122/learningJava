package com.wt.spring.aop;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/11 12:07
 */
public interface PointCutAdvisor extends Advisor {

    PointCut getPointCut();
}
