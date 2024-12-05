package com.wyh.application.assembler;

import com.wyh.application.api.request.LoginRequestDTO;
import com.wyh.application.api.response.LoginResponseDTO;
import com.wyh.application.assembler.mapper.LoginBOMapper;
import com.wyh.domain.bo.LoginRequestBO;
import com.wyh.domain.bo.LoginResponseBO;

public class LoginBOAssembler {

    public static LoginRequestBO toLoginRequestBO(LoginRequestDTO dto){
        return LoginBOMapper.INSTANCE.toLoginRequestBO(dto);
    }

    public static LoginResponseDTO toLoginResponseDTO(LoginResponseBO bo) {
        return LoginBOMapper.INSTANCE.toLoginResponseDTO(bo);
    }
}