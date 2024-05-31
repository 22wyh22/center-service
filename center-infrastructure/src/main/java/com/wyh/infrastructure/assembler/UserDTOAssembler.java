package com.wyh.infrastructure.assembler;

import com.wyh.application.api.response.UserLoginResponseDTO;
import com.wyh.infrastructure.assembler.mapper.UserDTOMapper;
import com.wyh.infrastructure.po.UserPO;

public class UserDTOAssembler {

    public static UserLoginResponseDTO toUserLoginResponseDTO(UserPO po){
        return UserDTOMapper.INSTANCE.toUserLoginResponseDTO(po);
    }
}