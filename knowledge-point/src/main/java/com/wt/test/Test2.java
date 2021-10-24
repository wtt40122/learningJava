package com.wt.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: wtt
 * @Date: 2021/5/10 19:27
 * @Description:
 */
public class Test2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 4};
        System.out.println(queryOverNum(arr));
    }

    public static Integer queryOverNum(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            if (map.get(arr[i]) != null) {
                map.put(arr[i], map.get(arr[i]) + 1);
                if (map.get(arr[i]) > n / 2) {
                    return arr[i];
                }
            } else {
                map.put(arr[i], 1);
            }
        }
//        Iterator<Integer> keySet = map.keySet().iterator();
//        while (keySet.hasNext()) {
//            Integer key = keySet.next();
//            Integer value = map.get(key);
//            if (null != value && value > n / 2) {
//                return key;
//            }
//        }
        return null;
    }
}
