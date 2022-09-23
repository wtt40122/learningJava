package com.wt.spring.core;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/22 17:22
 */
public interface ConversionService {

    boolean canConvert(Class<?> sourceType, Class<?> targetType);

    <T> T convert(Object source, Class<T> targetType);
}
