package com.wt.spring.annot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/11/26 21:59
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DoDoor {
    /**
     * 获取入参数类属性的值
     *
     * @return
     */
    String key() default "";

    /**
     * 拦截返回的json类容
     *
     * @return
     */
    String returnJson() default "";
}
