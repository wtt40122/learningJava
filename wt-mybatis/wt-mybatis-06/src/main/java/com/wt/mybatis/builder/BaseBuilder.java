package com.wt.mybatis.builder;

import com.wt.mybatis.session.Configuration;
import com.wt.mybatis.type.TypeAliasRegistry;

/**
 * @author: wtt
 * @date: 2022/7/31 19:14
 * @description:
 */
public class BaseBuilder {

    protected final Configuration configuration;

    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
