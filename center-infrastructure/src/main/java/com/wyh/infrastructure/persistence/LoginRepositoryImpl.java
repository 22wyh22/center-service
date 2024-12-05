package com.wyh.infrastructure.persistence;

import cn.hutool.crypto.digest.MD5;
import com.alibaba.fastjson.JSON;
import com.wyh.application.auth.util.JwtUtil;
import com.wyh.common.exception.UserErrorCode;
import com.wyh.common.util.AssertUtil;
import com.wyh.domain.bo.LoginRequestBO;
import com.wyh.domain.bo.LoginResponseBO;
import com.wyh.domain.bo.MenuTreeBO;
import com.wyh.domain.bo.SessionInfoBO;
import com.wyh.domain.repository.LoginRepository;
import com.wyh.factory.RedisTemplateFactory;
import com.wyh.infrastructure.po.SystemUserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
@Slf4j
public class LoginRepositoryImpl implements LoginRepository {

    private final RedisTemplate<String, Object> redisTemplate;

    private final SystemRepositoryImpl systemReadRepository;

    private final RedisScript<Long> loginScript = RedisScript.of(new ClassPathResource("lua/login.lua")
            , Long.class);


    public LoginRepositoryImpl(RedisTemplateFactory redisTemplateFactory,
                               SystemRepositoryImpl systemReadRepository) {
        this.redisTemplate = redisTemplateFactory.getRedisTemplate();
        this.systemReadRepository = systemReadRepository;
    }

    @Override
    public LoginResponseBO login(LoginRequestBO loginRequestBO) {
        String userId = loginRequestBO.getUserId();
        List<SystemUserPO> pos = systemReadRepository.queryUser(userId);
        //判断用户是否存在
        AssertUtil.notEmptyList(pos, UserErrorCode.USER_NOT_EXISTS);
        String digestHex = MD5.create().digestHex(loginRequestBO.getPassword());
        AssertUtil.asTrue(digestHex.equals(pos.get(0).getPassword()), UserErrorCode.USER_NOT_EXISTS);

        SessionInfoBO sessionInfo = new SessionInfoBO();
        sessionInfo.setUserId(userId);
        sessionInfo.setUserNm(pos.get(0).getUserNm());
        //菜单信息
        List<MenuTreeBO> menus = systemReadRepository.getMenuTree(userId);
        sessionInfo.setMenus(menus);

        String token = JwtUtil.INST.generateToken(userId);

        redisTemplate.execute(loginScript, Collections.singletonList(userId), token
                , JSON.toJSONString(sessionInfo), TimeUnit.HOURS.toSeconds(2));
        return new LoginResponseBO(token, sessionInfo);
    }
}
