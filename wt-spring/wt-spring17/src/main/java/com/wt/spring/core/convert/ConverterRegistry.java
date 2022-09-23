package com.wt.spring.core.convert;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/19 18:00
 */
public interface ConverterRegistry {

    void addConverter(Converter<?, ?> converter);

    void addConverter(GenericConverter converter);

    void addConverterFactory(ConverterFactory<?, ?> convertFactory);
}
