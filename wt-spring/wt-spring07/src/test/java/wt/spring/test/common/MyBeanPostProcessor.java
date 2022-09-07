package wt.spring.test.common;

import com.wt.spring.beans.BeansException;
import com.wt.spring.beans.factory.config.BeanPostProcessor;
import wt.spring.test.bean.UserService;

/**
 * @author: wtt
 * @date: 2022/9/4 19:13
 * @description:
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("北京市昌平区");
        }
        return bean;
    }

    @Override
    public Object postProcessorAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
