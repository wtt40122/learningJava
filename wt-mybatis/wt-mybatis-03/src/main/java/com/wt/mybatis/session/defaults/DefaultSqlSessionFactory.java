package com.wt.mybatis.session.defaults;

import com.wt.mybatis.session.Configuration;
import com.wt.mybatis.session.SqlSession;
import com.wt.mybatis.session.SqlSessionFactory;

/**
 * @author: wtt
 * @date: 2022/7/31 11:41
 * @description:
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }


    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
