package com.wt.netty25.util;

import com.alibaba.fastjson.JSON;
import com.wt.netty25.domain.InfoProtocol;
import com.wt.netty25.domain.msgobj.Text;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/17 18:40
 */
public class MsgUtil {
    public static String buildMsg(InfoProtocol infoProtocol) {
        return JSON.toJSONString(infoProtocol) + "\r\n";
    }

    public static InfoProtocol getMsg(String str) {
        return JSON.parseObject(str, InfoProtocol.class);
    }

    public static TextWebSocketFrame buildWsMsgText(String channelId, String msgInfo) {
        InfoProtocol infoProtocol = new InfoProtocol();
        infoProtocol.setChannelId(channelId);
        infoProtocol.setMsgType(1);
        infoProtocol.setMsgObj(new Text(msgInfo));
        return new TextWebSocketFrame(JSON.toJSONString(infoProtocol));
    }
}
