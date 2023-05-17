package com.wt.netty25.domain.msgobj;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/17 18:39
 */
public class Text {
    private String msg;

    public Text(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
