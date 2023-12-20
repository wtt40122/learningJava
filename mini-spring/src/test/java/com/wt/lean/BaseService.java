package com.wt.lean;

import com.wt.learn.beans.factory.annotation.Autowired;

/**
 * @Author: wtt
 * @Date: 2023/12/20 11:32
 * @Version: 1.0
 * @Description:
 */
public class BaseService {

    @Autowired
    private BaseBaseService bbs;

    public BaseBaseService getBbs() {
        return bbs;
    }

    public void setBbs(BaseBaseService bbs) {
        this.bbs = bbs;
    }

    public void sayHello() {
        System.out.println("Baser Service say hello");
        bbs.sayHello();
    }
}
