package com.wt.mybatis.session;

import com.wt.mybatis.builder.xml.XMLConfigBuilder;
import com.wt.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @author: wtt
 * @date: 2022/7/31 19:13
 * @description:
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader){
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
