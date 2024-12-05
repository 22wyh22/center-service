package com.wyh.application.auth.interceptor;

import cn.hutool.extra.servlet.ServletUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wyh.application.auth.util.JwtUtil;
import com.wyh.common.exception.BizException;
import com.wyh.common.exception.ErrorCode;
import com.wyh.common.util.AssertUtil;
import com.wyh.common.util.ThreadLocalUtil;
import com.wyh.factory.RedisTemplateFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {

    private final RedisTemplate<String, Object> redisTemplate;

    private TokenInterceptor(RedisTemplateFactory redisTemplateFactory){
        this.redisTemplate = redisTemplateFactory.getRedisTemplate();
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("TokenInterceptor---preHandle");
        String token = request.getHeader("_ut");
        String requestURI = request.getRequestURI();
        String ip = Optional.ofNullable(ServletUtil.getClientIP(request)).orElse("IP IS NULL");
        log.info("请求地址:{}", ip);
        log.info("接口路径>>>{}", requestURI);
        log.info("请求body:\n{}", ServletUtil.getBody(request));
        return checkToken(token);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("TokenInterceptor---afterCompletion");
        ThreadLocalUtil.removeAll();
    }

    private boolean checkToken(String token) {
        AssertUtil.asTrue(StringUtils.isNotEmpty(token), ErrorCode.TOKEN_ERROR);
        DecodedJWT jwt;
        try {
            jwt = JwtUtil.INST.checkToken(token);
        }catch (Exception ex){
            throw new BizException(ErrorCode.TOKEN_ERROR);
        }
        String userId = jwt.getSubject();
        AssertUtil.asTrue(this.redisTemplate.hasKey(userId), ErrorCode.TOKEN_ERROR);
        HashOperations<String, String, Object> hash = this.redisTemplate.opsForHash();
        Object obj = hash.get(userId, "token");
        AssertUtil.asTrue(token.equals(obj), ErrorCode.TOKEN_ERROR);
        this.redisTemplate.expire(userId, 2, TimeUnit.HOURS);
        ThreadLocalUtil.set("userId", userId);
        return true;
    }
}
