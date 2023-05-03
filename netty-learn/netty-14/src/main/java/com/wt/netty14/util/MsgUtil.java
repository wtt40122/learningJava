package com.wt.netty14.util;

import com.wt.netty14.domain.MsgBody;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/3 14:44
 */
public class MsgUtil {
    /**
     * 构建protobuf消息体
     */
    public static MsgBody buildMsg(String channelId, String msgInfo) {
        MsgBody.Builder msg = MsgBody.newBuilder();
        msg.setChannelId(channelId);
        msg.setMsgInfo(msgInfo);
        return msg.build();
    }
}
