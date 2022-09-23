package com.wt.spring.test17;

import com.wt.spring.context.support.ClassPathXmlApplicationContext;
import com.wt.spring.core.convert.Converter;
import com.wt.spring.core.support.StringToNumberConverterFactory;
import com.wt.spring.test17.bean.Husband;
import com.wt.spring.test17.converter.StringToIntegerConverter;
import org.junit.Test;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/19 17:54
 */
public class ApiTest {

    @Test
    public void test_convert() {
        ClassPathXmlApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("classpath:spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        System.out.println("结果：" + husband);
    }

    @Test
    public void test_stringToIntegerConverter() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer num = converter.convert("3545");
        System.out.println("测试结果：" + num);
    }

    @Test
    public void test_StringToNumberConverterFactory() {
        StringToNumberConverterFactory converterFactory = new StringToNumberConverterFactory();
        Converter<String, Integer> integerConverter = converterFactory.getConverter(Integer.class);
        System.out.println("测试结果：" + integerConverter.convert("654646546"));
        Converter<String, Long> longConverter = converterFactory.getConverter(Long.class);
        System.out.println("测试结果：" + longConverter.convert("756757"));
    }
}
