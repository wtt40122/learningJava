package com.wt.netty21.util;

import com.alibaba.fastjson.JSON;
import com.wt.netty21.domain.MsgAgreement;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/5 9:56
 */
public class MsgUtil {
    public static MsgAgreement buildMsg(String channelId, String content) {
        return new MsgAgreement(channelId, content);
    }

    public static MsgAgreement json2Obj(String objJsonStr) {
        return JSON.parseObject(objJsonStr, MsgAgreement.class);
    }

    public static String obj2Json(MsgAgreement msgAgreement) {
        return JSON.toJSONString(msgAgreement) + "\r\n";
    }
}
