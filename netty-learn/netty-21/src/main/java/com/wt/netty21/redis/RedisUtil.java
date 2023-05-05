package com.wt.netty21.redis;

import com.alibaba.fastjson.JSON;
import com.wt.netty21.domain.UserChannelInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/5 10:00
 */
@Service
public class RedisUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void pushObj(UserChannelInfo userChannelInfo) {
        redisTemplate.opsForHash().put("netty-21-user", userChannelInfo.getChannelId(), JSON.toJSONString(userChannelInfo));
    }

    public List<UserChannelInfo> popList() {
        List<Object> values = redisTemplate.opsForHash().values("netty-21-user");
        if (null == values) {
            return new ArrayList<>();
        }
        List<UserChannelInfo> userChannelInfoList = new ArrayList<>();
        for (Object strJson : values) {
            userChannelInfoList.add(JSON.parseObject(strJson.toString(), UserChannelInfo.class));
        }
        return userChannelInfoList;
    }

    public void remove(String channelId) {
        redisTemplate.opsForHash().delete("netty-21-user",channelId);
    }

    public void clear(){
        redisTemplate.delete("netty-21-user");
    }
}
