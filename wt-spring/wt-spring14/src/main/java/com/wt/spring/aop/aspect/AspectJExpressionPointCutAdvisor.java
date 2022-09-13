package com.wt.spring.aop.aspect;

import com.wt.spring.aop.PointCut;
import com.wt.spring.aop.PointCutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/11 12:08
 */
public class AspectJExpressionPointCutAdvisor implements PointCutAdvisor {

    private AspectJExpressionPointCut pointCut;
    private Advice advice;
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public PointCut getPointCut() {
        if (null == pointCut) {
            pointCut = new AspectJExpressionPointCut(expression);
        }
        return pointCut;
    }
}
