package com.wt.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author wtt
 * @version 1.0
 * @description 数据源工厂
 * @date 2022/8/1 10:32
 */
public interface DataSourceFactory {

    void setProperties(Properties props);

    DataSource getDataSource();

}
