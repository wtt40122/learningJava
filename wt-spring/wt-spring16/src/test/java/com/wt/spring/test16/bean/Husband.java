package com.wt.spring.test16.bean;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/16 16:58
 */
public class Husband {

    private Wife wife;

    public String queryWife(){
        return "Husband.wife";
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
