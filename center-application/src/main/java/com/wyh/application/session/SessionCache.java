package com.wyh.application.session;


import com.alibaba.fastjson.JSON;
import com.wyh.common.util.ThreadLocalUtil;
import com.wyh.domain.bo.SessionInfoBO;
import com.wyh.factory.RedisTemplateFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class SessionCache {

    private final RedisTemplate<String, Object> redisTemplate;

    public SessionCache(RedisTemplateFactory redisTemplateFactory) {
        this.redisTemplate = redisTemplateFactory.getRedisTemplate();
    }

    public SessionInfoBO getSession(){
        String userId = (String) ThreadLocalUtil.get("userId");
        String result = (String) redisTemplate.opsForHash().get(userId, "info");
        return JSON.parseObject(result, SessionInfoBO.class);
    }
}
