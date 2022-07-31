package com.wt.mybatis.session.defaults;

import com.wt.mybatis.mapping.MappedStatement;
import com.wt.mybatis.session.Configuration;
import com.wt.mybatis.session.SqlSession;

/**
 * @author: wtt
 * @date: 2022/7/31 11:40
 * @description:
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
