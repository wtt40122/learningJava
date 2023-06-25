package com.wt.spring.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/3 15:16
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "智多星吴用");
        hashMap.put("10002", "九纹龙史进");
        hashMap.put("10003", "锦毛鼠白玉堂");
    }

    public void addData(String key, String value) {
        hashMap.put(key, value);
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
