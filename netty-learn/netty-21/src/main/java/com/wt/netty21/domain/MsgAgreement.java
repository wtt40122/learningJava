package com.wt.netty21.domain;

/**
 * @author wtt
 * @version 1.0
 * @description 消息协议
 * @date 2023/5/5 9:41
 */
public class MsgAgreement {
    private String toChannelId;
    private String content;

    public MsgAgreement() {
    }

    public MsgAgreement(String toChannelId, String content) {
        this.toChannelId = toChannelId;
        this.content = content;
    }

    public String getToChannelId() {
        return toChannelId;
    }

    public void setToChannelId(String toChannelId) {
        this.toChannelId = toChannelId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
