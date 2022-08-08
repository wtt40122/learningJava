package com.wt.mybatis.mapping;

import com.wt.mybatis.session.Configuration;
import com.wt.mybatis.type.JdbcType;
import com.wt.mybatis.type.TypeHandler;

/**
 * @author wtt
 * @version 1.0
 * @description 结果映射
 * @date 2022/8/5 19:41
 */
public class ResultMapping {

    private Configuration configuration;
    private String property;
    private String column;
    private Class<?> javaType;
    private JdbcType jdbcType;
    private TypeHandler<?> typeHandler;

    ResultMapping() {
    }

    public static class Builder {
        private ResultMapping resultMapping = new ResultMapping();


    }
}
