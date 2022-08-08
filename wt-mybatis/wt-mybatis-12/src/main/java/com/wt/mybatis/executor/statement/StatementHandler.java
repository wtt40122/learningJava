package com.wt.mybatis.executor.statement;

import com.wt.mybatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description 语句处理器
 * @date 2022/8/1 21:01
 */
public interface StatementHandler {

    /** 准备语句 */
    Statement prepare(Connection connection) throws SQLException;

    /** 参数化 */
    void parameterize(Statement statement) throws SQLException;

    /** 执行更新 */
    int update(Statement statement) throws SQLException;

    /** 执行查询 */
    <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException;

}
