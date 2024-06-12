package com.wyh.infrastructure.persistence;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wyh.application.api.request.UserLoginRequestDTO;
import com.wyh.application.api.response.UserLoginResponseDTO;
import com.wyh.application.repository.LoginUserTokenRepository;
import com.wyh.common.constant.RedisConstant;
import com.wyh.common.exception.UserErrorCode;
import com.wyh.common.util.AssertUtil;
import com.wyh.common.util.TokenUtil;
import com.wyh.factory.RedisTemplateFactory;
import com.wyh.infrastructure.assembler.UserDTOAssembler;
import com.wyh.infrastructure.po.UserPO;
import com.wyh.infrastructure.repository.UserPORepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class LoginUserTokenRepositoryImpl implements LoginUserTokenRepository {

    private final RedisTemplate<String, Object> redisTemplate;

    private final UserPORepository userPORepository;


    public LoginUserTokenRepositoryImpl(RedisTemplateFactory redisTemplateFactory,
                                        UserPORepository userPORepository) {
        this.redisTemplate = redisTemplateFactory.getRedisTemplate();
        this.userPORepository = userPORepository;
    }

    @Override
    public boolean checkToken(String userId,String token) {
        String key = RedisConstant.TOKEN_KEY + "_" + userId;
        Object value = redisTemplate.opsForValue().get(key);
        return token.equals(value);
    }

    @Override
    public UserLoginResponseDTO login(UserLoginRequestDTO userLoginRequestDTO) {
        LambdaQueryWrapper<UserPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserPO::getUserId, userLoginRequestDTO.getUserId());
        List<UserPO> pos = userPORepository.getBaseMapper().selectList(wrapper);
        AssertUtil.notEmptyList(pos, UserErrorCode.USER_EXISTS);
        UserLoginResponseDTO responseDTO = UserDTOAssembler.toUserLoginResponseDTO(pos.get(0));
        responseDTO.setToken(TokenUtil.getToken(responseDTO.getUserId()));

        String key = RedisConstant.TOKEN_KEY + "_" + responseDTO.getUserId();
        redisTemplate.opsForValue().set(key, responseDTO.getToken(),10*60, TimeUnit.SECONDS);
        return responseDTO;
    }
}
