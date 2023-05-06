package com.wt.netty22.util;

import com.wt.netty22.domain.MsgDemo01;
import com.wt.netty22.domain.MsgDemo02;
import com.wt.netty22.domain.MsgDemo03;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/5 18:57
 */
public class MsgUtil {

    public static MsgDemo01 buildMsgDemo01(String channelId, String msgContent) {
        return new MsgDemo01(channelId, msgContent);
    }

    public static MsgDemo02 buildMsgDemo02(String channelId, String msgContent) {
        return new MsgDemo02(channelId, msgContent);
    }

    public static MsgDemo03 buildMsgDemo03(String channelId, String msgContent) {
        return new MsgDemo03(channelId, msgContent);
    }
}
