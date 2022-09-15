package com.wt.spring.stereotype;

import java.lang.annotation.*;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/12 19:18
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
    String value() default "";
}
