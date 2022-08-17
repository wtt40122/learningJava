package com.wt.mybatis.session;

/**
 * @author wtt
 * @version 1.0
 * @description 结果处理器
 * @date 2022/8/1 20:57
 */
public interface ResultHandler {

    /**
     * 处理结果
     */
    void handleResult(ResultContext context);

}
