package com.wt.learn;


/**
 * @author wtt
 * @version 1.0
 * @description -XX:NewSize=104857600 -XX:MaxNewSize=104857600 -XX:InitialHeapSize=209715200 -XX:MaxHeapSize=209715200 -
 * XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=20971520 -XX:+UseParNewGC -
 * XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 * @date 2023/11/4 21:15
 */
public class Demo05 {
    public static void main(String[] args) throws Exception {
        Thread.sleep(30000);
        while (true) {
            loadData();
        }

    }

    private static void loadData() throws Exception {
        byte[] data = null;
        for (int i = 0; i < 4; i++) {
            data = new byte[10 * 1024 * 1024];
        }
        data = null;
        byte[] data1 = new byte[10 * 1024 * 1024];
        byte[] data2 = new byte[10 * 1024 * 1024];

        byte[] data3 = new byte[10 * 1024 * 1024];
        data3 = new byte[10 * 1024 * 1024];

        Thread.sleep(1000);
    }
}
