package com.wyh.application.assembler.mapper;

import com.wyh.application.api.request.AddRoleRequestDTO;
import com.wyh.domain.bo.AddRoleBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SystemBOMapper {

    SystemBOMapper INSTANCE = Mappers.getMapper(SystemBOMapper.class);

    AddRoleBO toAddRoleBO(AddRoleRequestDTO requestDTO);
}
