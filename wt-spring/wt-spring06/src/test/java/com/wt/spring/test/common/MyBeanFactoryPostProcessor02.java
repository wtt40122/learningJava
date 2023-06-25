package com.wt.spring.test.common;

import com.wt.spring.beans.BeansException;
import com.wt.spring.beans.factory.ConfigurableListableBeanFactory;
import com.wt.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.wt.spring.test.bean.UserDao;

import java.util.Map;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/6/12 10:32
 */
public class MyBeanFactoryPostProcessor02 implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, UserDao> userDaoMap = beanFactory.getBeansOfType(UserDao.class);
        userDaoMap.forEach((s, userDao) -> {
            userDao.addData("12342", "45656");
        });
    }
}
