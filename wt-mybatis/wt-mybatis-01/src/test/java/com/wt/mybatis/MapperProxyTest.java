package com.wt.mybatis;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wtt
 * @date: 2022/7/30 18:46
 * @description: 每个dao接口一个MapperProxyFactory类，一个MapperProxy类
 */
public class MapperProxyTest {

    private Logger logger = LoggerFactory.getLogger(MapperProxyTest.class);


    @Test
    public void testMapperProxyFactory() {
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);

        Map<String, Object> sqlSession = new HashMap<>();
        sqlSession.put("com.wt.mybatis.IUserDao.queryUserName", "张三");
        sqlSession.put("com.wt.mybatis.IUserDao.queryUserAge", 20);
        IUserDao userDao = factory.newInstance(sqlSession);

        String queryUserName = userDao.queryUserName("10001");
        logger.info("测试queryUserName结果：{}", queryUserName);
        Integer queryUserAge = userDao.queryUserAge("张三");
        logger.info("测试queryUserAge结果：{}", queryUserAge);

        int hashCode = userDao.hashCode();
        logger.info("测试hashCode结果：{}", hashCode);

    }
}


