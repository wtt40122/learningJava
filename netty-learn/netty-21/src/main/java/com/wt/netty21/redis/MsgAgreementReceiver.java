package com.wt.netty21.redis;

import com.alibaba.fastjson.JSON;
import com.wt.netty21.domain.MsgAgreement;
import com.wt.netty21.util.CacheUtil;
import com.wt.netty21.util.MsgUtil;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/5 9:59
 */
@Service
public class MsgAgreementReceiver extends AbstractReceiver {

    private Logger logger = LoggerFactory.getLogger(MsgAgreementReceiver.class);

    @Override
    public void receiveMessage(Object message) {
        logger.info("接收到PUSH消息：{}", message);
        MsgAgreement msgAgreement = JSON.parseObject(message.toString(), MsgAgreement.class);
        String toChannelId = msgAgreement.getToChannelId();
        Channel channel = CacheUtil.cacheChannel.get(toChannelId);
        if (null == channel) {
            return;
        }
        channel.writeAndFlush(MsgUtil.obj2Json(msgAgreement));
    }
}
