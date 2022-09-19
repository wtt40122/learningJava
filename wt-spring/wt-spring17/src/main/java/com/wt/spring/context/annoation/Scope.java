package com.wt.spring.context.annoation;

import java.lang.annotation.*;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/12 19:16
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {
    String value() default "singleton";
}
