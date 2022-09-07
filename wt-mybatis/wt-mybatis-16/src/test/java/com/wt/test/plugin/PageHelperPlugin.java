package com.wt.test.plugin;

import cn.hutool.core.bean.BeanUtil;
import com.wt.mybatis.executor.statement.StatementHandler;
import com.wt.mybatis.mapping.BoundSql;
import com.wt.mybatis.plugin.Interceptor;
import com.wt.mybatis.plugin.Intercepts;
import com.wt.mybatis.plugin.Invocation;
import com.wt.mybatis.plugin.Signature;
import com.wt.mybatis.session.ResultHandler;

import java.sql.Statement;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/5 11:01
 */
@Intercepts(value = {@Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class})})
public class PageHelperPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        Integer start = 0;
        Integer pageSize = 10;
        String pageSql = String.format("select * from (%s) as origin limit %s,%s", sql, start, pageSize);
        BeanUtil.setFieldValue(boundSql, sql, pageSql);
        return invocation.proceed();
    }
}
