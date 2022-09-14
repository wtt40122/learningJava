package com.wt.spring.test15.bean;

import com.wt.spring.beans.factory.InitializingBean;
import com.wt.spring.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/3 15:16
 */
@Component
public class UserDao implements InitializingBean {
    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod() {
        System.out.println("执行：init-method");
        hashMap.put("10001", "小傅哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public void destroyDataMethod() {
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initDataMethod();
    }
}
