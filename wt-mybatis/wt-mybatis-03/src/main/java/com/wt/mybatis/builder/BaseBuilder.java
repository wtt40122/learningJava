package com.wt.mybatis.builder;

import com.wt.mybatis.session.Configuration;

/**
 * @author: wtt
 * @date: 2022/7/31 19:14
 * @description:
 */
public class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
