package com.wt.lean;

/**
 * @Author: wtt
 * @Date: 2023/12/20 11:33
 * @Version: 1.0
 * @Description:
 */
public class BaseBaseService {

    private AServiceImpl as;

    public AServiceImpl getAs() {
        return as;
    }

    public void setAs(AServiceImpl as) {
        this.as = as;
    }

    public void sayHello(){
        System.out.println("Base Base service say hello");
    }

}
