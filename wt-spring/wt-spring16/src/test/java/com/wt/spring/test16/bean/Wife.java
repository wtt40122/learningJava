package com.wt.spring.test16.bean;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/16 16:58
 */
public class Wife {

    private Husband husband;
    private IMother mother;

    public String queryHusband() {
        return "Wife.husband、Mother.callMother：" + mother.callMother();
    }

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    public IMother getMother() {
        return mother;
    }

    public void setMother(IMother mother) {
        this.mother = mother;
    }
}
