package com.wt.netty25.domain.msgobj;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/17 18:39
 */
public class Feedback {
    private String channelId;   //设备ID{管道ID}
    private Integer stateType; //状态类型;1\2
    private String stateMsg;   //状态信息

    public Feedback(String channelId, Integer stateType, String stateMsg) {
        this.channelId = channelId;
        this.stateType = stateType;
        this.stateMsg = stateMsg;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Integer getStateType() {
        return stateType;
    }

    public void setStateType(Integer stateType) {
        this.stateType = stateType;
    }

    public String getStateMsg() {
        return stateMsg;
    }

    public void setStateMsg(String stateMsg) {
        this.stateMsg = stateMsg;
    }
}
