package com.wyh.application.auth.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class JwtUtil {
    /**
     * 饿汉单例
     */
    public static final JwtUtil INST = new JwtUtil();
    /**
     * 私有构造
     */
    private JwtUtil(){}
    /**
     * 密钥
     */
    private String secret;
    /**
     * 过期时间-单位秒
     */
    private long expire;

    public void init(String secret, long expire){
        this.secret = secret;
        this.expire = expire;
    }

    /**
     * 生成token
     *
     * @param identityId 认证信息
     * @return str
     */
    public String generateToken(String identityId) {
        log.info("JWT开始生成TOKEN,identityId:{}", identityId);
        Map<String, Object> header = new HashMap<>();
        header.put("typ","JWT");
        header.put("alg", "HS256");
        return JWT.create().withHeader(header)
                .withClaim("sub", identityId)
                .withClaim("traceId", UUID.randomUUID().toString().replaceAll("-", ""))
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + expire * 1000))
                .sign(Algorithm.HMAC256(secret));
    }

    /**
     * 解析token
     * @param token token
     * @return jwt
     */
    public DecodedJWT checkToken(String token){
        return JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
    }
}
