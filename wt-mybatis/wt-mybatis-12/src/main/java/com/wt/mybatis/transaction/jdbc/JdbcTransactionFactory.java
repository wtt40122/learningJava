package com.wt.mybatis.transaction.jdbc;

import com.wt.mybatis.session.TransactionIsolationLevel;
import com.wt.mybatis.transaction.Transaction;
import com.wt.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/1 10:11
 */
public class JdbcTransactionFactory implements TransactionFactory {
    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }
}
