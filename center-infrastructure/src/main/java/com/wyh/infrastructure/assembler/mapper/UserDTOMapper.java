package com.wyh.infrastructure.assembler.mapper;

import com.wyh.application.api.response.UserLoginResponseDTO;
import com.wyh.infrastructure.po.UserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDTOMapper {

    UserDTOMapper INSTANCE = Mappers.getMapper(UserDTOMapper.class);

    UserLoginResponseDTO toUserLoginResponseDTO(UserPO po);
}
