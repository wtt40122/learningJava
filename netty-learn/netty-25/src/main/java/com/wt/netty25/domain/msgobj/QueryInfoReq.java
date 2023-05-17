package com.wt.netty25.domain.msgobj;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/17 18:39
 */
public class QueryInfoReq {
    private Integer stateType; //类型；Feedback=>{1\2}

    public QueryInfoReq(Integer stateType) {
        this.stateType = stateType;
    }

    public Integer getStateType() {
        return stateType;
    }

    public void setStateType(Integer stateType) {
        this.stateType = stateType;
    }
}
