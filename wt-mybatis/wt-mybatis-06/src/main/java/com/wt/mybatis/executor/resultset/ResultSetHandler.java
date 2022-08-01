package com.wt.mybatis.executor.resultset;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description 结果集处理器
 * @date 2022/8/1 21:02
 */
public interface ResultSetHandler {

    <E> List<E> handleResultSets(Statement stmt) throws SQLException;

}
