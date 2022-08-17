package com.wt.mybatis.session;

/**
 * @author: wtt
 * @date: 2022/7/31 11:39
 * @description:
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     */
    SqlSession openSession();
}
