package com.wt.spring.core.convert;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/19 17:56
 */
public interface Converter<S, T> {
    T convert(S source);
}
