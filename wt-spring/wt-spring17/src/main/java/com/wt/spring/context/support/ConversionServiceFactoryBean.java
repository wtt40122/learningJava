package com.wt.spring.context.support;

import com.wt.spring.beans.factory.FactoryBean;
import com.wt.spring.beans.factory.InitializingBean;
import com.wt.spring.core.ConversionService;
import com.wt.spring.core.convert.Converter;
import com.wt.spring.core.convert.ConverterFactory;
import com.wt.spring.core.convert.GenericConverter;
import com.wt.spring.core.support.DefaultConversionService;
import com.wt.spring.core.support.GenericConversionService;

import java.util.Set;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/22 19:36
 */
public class ConversionServiceFactoryBean implements FactoryBean<ConversionService>, InitializingBean {

    private Set<?> converters;
    private GenericConversionService conversionService;

    @Override
    public ConversionService getObject() throws Exception {
        return conversionService;
    }

    @Override
    public Class<?> getObjectType() {
        return conversionService.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.conversionService = new DefaultConversionService();
        registerConverters(converters, conversionService);
    }

    private void registerConverters(Set<?> converts, GenericConversionService registry) {
        if (null != converts) {
            for (Object converter : converts) {
                if (converter instanceof GenericConverter) {
                    registry.addConverter((GenericConverter) converter);
                } else if (converter instanceof Converter<?, ?>) {
                    registry.addConverter((Converter<?, ?>) converter);
                } else if (converter instanceof ConverterFactory<?, ?>) {
                    registry.addConverterFactory((ConverterFactory<?, ?>) converter);
                } else {
                    throw new IllegalArgumentException("Each converter object must implement one of the " +
                            "Converter, ConverterFactory, or GenericConverter interfaces");

                }
            }
        }
    }

    public void setConverts(Set<?> converters) {
        this.converters = converters;
    }
}
