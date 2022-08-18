package com.wt.mybatis.builder;

import com.wt.mybatis.mapping.BoundSql;
import com.wt.mybatis.mapping.ParameterMapping;
import com.wt.mybatis.mapping.SqlSource;
import com.wt.mybatis.session.Configuration;

import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description 静态SQL源码
 * @date 2022/8/2 20:20
 */
public class StaticSqlSource implements SqlSource {
    private String sql;
    private List<ParameterMapping> parameterMappings;
    private Configuration configuration;

    public StaticSqlSource(Configuration configuration, String sql) {
        this(configuration, sql, null);
    }

    public StaticSqlSource(Configuration configuration, String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.configuration = configuration;
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return new BoundSql(configuration, sql, parameterMappings, parameterObject);
    }

}
