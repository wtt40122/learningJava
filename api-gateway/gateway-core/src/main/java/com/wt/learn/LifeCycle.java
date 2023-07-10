package com.wt.learn;

/**
 * @Author: wtt
 * @Date: 2023/7/6 23:57
 * @Version: 1.0
 * @Description:
 */
public interface LifeCycle {

    /**
     * 初始化
     */
    void init();

    /**
     * 启动
     */
    void start();

    /**
     * 关闭
     */
    void shutDown();
}
