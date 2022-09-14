package com.wt.spring.test15;

import com.wt.spring.aop.MethodMatcher;
import com.wt.spring.aop.aspect.AspectJExpressionPointCut;
import com.wt.spring.aop.framework.ReflectiveMethodInvocation;
import com.wt.spring.test15.bean.BookService;
import com.wt.spring.test15.bean.IBookService;
import com.wt.spring.test15.bean.UserService;
import com.wt.spring.util.ClassUtils;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wtt
 * @version 1.0
 * @description 代理测试
 * @date 2022/9/10 16:49
 */
public class ProxyTest {

    @Test
    public void test_proxy() {
        BookService targetObj = new BookService();
        IBookService bookService = (IBookService) Proxy.newProxyInstance(ClassUtils.getClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {
            MethodMatcher methodMatcher = new AspectJExpressionPointCut("execution(* com.wt.spring.test15.bean.IBookService.*(..))");

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodMatcher.matches(method, targetObj.getClass())) {
                    MethodInterceptor methodInterceptor = methodInvocation -> {
                        long start = System.currentTimeMillis();
                        try {
                            return methodInvocation.proceed();
                        } finally {
                            System.out.println("监控 - Begin By AOP");
                            System.out.println("方法名称：" + methodInvocation.getMethod().getName());
                            System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                            System.out.println("监控 - End\r\n");
                        }
                    };
                    return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
                }
                return method.invoke(targetObj, args);
            }
        });
        String result = bookService.queryBookInfo();
        System.out.println("测试结果:" + result);
    }

    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointCut expressionPointCut = new AspectJExpressionPointCut("execution(* com.wt.spring.test11.bean.UserService.*(..))");
        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");
        System.out.println(expressionPointCut.matches(clazz));
        System.out.println(expressionPointCut.matches(method, clazz));
    }
}
