package com.wt.spring.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/14 11:33
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Inherited
@Documented
public @interface Qualifier {
    String value() default "";
}
