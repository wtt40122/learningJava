package com.wt.netty.rpc.config;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/10 9:35
 */
public class ConsumerConfig<T> {
    protected String nozzle; //接口
    protected String alias;  //别名

    public String getNozzle() {
        return nozzle;
    }

    public void setNozzle(String nozzle) {
        this.nozzle = nozzle;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
