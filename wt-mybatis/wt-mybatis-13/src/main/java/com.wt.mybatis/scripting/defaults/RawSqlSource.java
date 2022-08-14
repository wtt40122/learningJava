package com.wt.mybatis.scripting.defaults;

import com.wt.mybatis.builder.SqlSourceBuilder;
import com.wt.mybatis.mapping.BoundSql;
import com.wt.mybatis.mapping.SqlSource;
import com.wt.mybatis.scripting.xmltags.DynamicContext;
import com.wt.mybatis.scripting.xmltags.SqlNode;
import com.wt.mybatis.session.Configuration;

import java.util.HashMap;

/**
 * @author wtt
 * @version 1.0
 * @description 原始SQL源码，比 DynamicSqlSource 动态SQL处理快
 * @date 2022/8/2 20:17
 */
public class RawSqlSource implements SqlSource {

    private final SqlSource sqlSource;

    public RawSqlSource(Configuration configuration, SqlNode rootSqlNode, Class<?> parameterType) {
        this(configuration, getSql(configuration, rootSqlNode), parameterType);
    }

    public RawSqlSource(Configuration configuration, String sql, Class<?> parameterType) {
        SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(configuration);
        Class<?> clazz = parameterType == null ? Object.class : parameterType;
        sqlSource = sqlSourceParser.parse(sql, clazz, new HashMap<>());
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return sqlSource.getBoundSql(parameterObject);
    }

    private static String getSql(Configuration configuration, SqlNode rootSqlNode) {
        DynamicContext context = new DynamicContext(configuration, null);
        rootSqlNode.apply(context);
        return context.getSql();
    }

}
