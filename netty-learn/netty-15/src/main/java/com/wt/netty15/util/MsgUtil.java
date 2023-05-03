package com.wt.netty15.util;

import com.wt.netty15.domain.MsgInfo;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/3 15:20
 */
public class MsgUtil {
    public static MsgInfo buildMsg(String channelId, String msgContent) {
        return new MsgInfo(channelId, msgContent);
    }

}
