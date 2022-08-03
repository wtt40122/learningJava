package com.wt.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author wtt
 * @version 1.0
 * @description String类型处理器
 * @date 2022/8/2 20:23
 */
public class StringTypeHandler extends BaseTypeHandler<String> {
    @Override
    protected void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter);
    }
}
