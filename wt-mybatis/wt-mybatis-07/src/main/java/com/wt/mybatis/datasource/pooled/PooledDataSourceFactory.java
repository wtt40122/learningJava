package com.wt.mybatis.datasource.pooled;

import com.wt.mybatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/1 12:15
 */
public class PooledDataSourceFactory extends UnpooledDataSourceFactory {

    public PooledDataSourceFactory() {
        this.dataSource = new PooledDataSource();
    }

}
