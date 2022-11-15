package com.wt.source;

import com.alibaba.fastjson.JSON;
import com.wt.source.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * @author: wtt
 * @date: 2022/9/17 15:01
 * @description:
 */
public class MybatisApiTest {

    @Test
    public void test_queryUserInfoById() {
        String source = "spring/mybatis-config-datasource.xml";
        try {
            Reader reader = Resources.getResourceAsReader(source);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession sqlSession = sqlSessionFactory.openSession();
            try {
                User user = sqlSession.selectOne("com.wt.source.dao.IUserDao.queryUserInfoById", 1L);
                System.out.println(JSON.toJSONString(user));
            } finally {
                sqlSession.close();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
