package com.wt.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author wtt
 * @version 1.0
 * @description 类型处理器
 * @date 2022/8/2 20:21
 */
public interface TypeHandler<T> {
    /**
     * 设置参数
     */
    void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;

    /**
     * 获取结果
     */
    T getResult(ResultSet rs, String columnName) throws SQLException;

    /**
     * 取得结果
     */
    T getResult(ResultSet rs, int columnIndex) throws SQLException;

}
