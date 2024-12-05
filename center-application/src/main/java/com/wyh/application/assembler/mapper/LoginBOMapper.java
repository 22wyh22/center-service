package com.wyh.application.assembler.mapper;

import com.wyh.application.api.request.LoginRequestDTO;
import com.wyh.application.api.response.LoginResponseDTO;
import com.wyh.domain.bo.LoginRequestBO;
import com.wyh.domain.bo.LoginResponseBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoginBOMapper {

    LoginBOMapper INSTANCE = Mappers.getMapper(LoginBOMapper.class);

    LoginRequestBO toLoginRequestBO(LoginRequestDTO dto);

    LoginResponseDTO toLoginResponseDTO(LoginResponseBO bo);
}
