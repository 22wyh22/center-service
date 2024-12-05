package com.wyh.application.auth.jwt;

import com.wyh.application.auth.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtConfiguration implements InitializingBean {
    /**
     * 密钥
     */
    @Value("${jwt.secret:wuyuhan}")
    private String secret;
    /**
     * 过期时间-单位秒
     */
    @Value("${jwt.expire:3600}")
    private long expire;

    @Override
    public void afterPropertiesSet() throws Exception {
        JwtUtil.INST.init(secret, expire);
    }
}
