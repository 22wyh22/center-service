package com.wyh.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class TokenUtil {

    private static final String SECRET = "TOKEN_SECRET_WUYUHAN";

    public static String getToken(String userId){
        //用秘钥生成签名
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        //默认头部+载荷（id）+签名=jwt
        String jwtToken= JWT.create()
                .withClaim("userId", userId)
                .sign(algorithm);
        return jwtToken;
    }
}
