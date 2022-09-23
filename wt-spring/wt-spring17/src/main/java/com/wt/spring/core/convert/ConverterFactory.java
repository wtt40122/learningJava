package com.wt.spring.core.convert;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/19 17:57
 */
public interface ConverterFactory<S, R> {
    <T extends R> Converter<S, T> getConverter(Class<T> targetType);
}
