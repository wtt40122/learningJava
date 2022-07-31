package com.wt.mybatis;

import com.wt.mybatis.Dao.IUserDao;
import com.wt.mybatis.binding.MapperRegistry;
import com.wt.mybatis.session.SqlSession;
import com.wt.mybatis.session.SqlSessionFactory;
import com.wt.mybatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: wtt
 * @date: 2022/7/31 12:01
 * @description:
 */
public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("com.wt.mybatis.Dao");

        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 4. 测试验证
        String res = userDao.queryUserName("10001");
        logger.info("测试结果：{}", res);
    }

}
