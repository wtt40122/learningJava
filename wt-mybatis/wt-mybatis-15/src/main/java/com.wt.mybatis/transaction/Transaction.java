package com.wt.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/1 10:02
 */
public interface Transaction {

    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;
}
