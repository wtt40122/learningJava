package com.wt.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/2 20:23
 */
public class LongTypeHandler extends BaseTypeHandler<Long> {
    @Override
    protected void setNonNullParameter(PreparedStatement ps, int i, Long parameter, JdbcType jdbcType) throws SQLException {
        ps.setLong(i, parameter);
    }
}
