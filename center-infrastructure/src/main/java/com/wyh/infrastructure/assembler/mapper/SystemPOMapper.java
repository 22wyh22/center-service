package com.wyh.infrastructure.assembler.mapper;

import cn.hutool.core.util.IdUtil;
import com.wyh.application.api.response.QueryMenuResponseDTO;
import com.wyh.application.api.response.QueryRoleResponseDTO;
import com.wyh.domain.bo.AddRoleBO;
import com.wyh.domain.bo.MenuTreeBO;
import com.wyh.infrastructure.po.SystemMenuPO;
import com.wyh.infrastructure.po.SystemRolePO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;

@Mapper(imports = {IdUtil.class, Date.class})
public interface SystemPOMapper {

    SystemPOMapper INSTANCE = Mappers.getMapper(SystemPOMapper.class);

    QueryMenuResponseDTO toQueryMenuResponseDTO(SystemMenuPO po);

    List<QueryMenuResponseDTO> toQueryMenuResponseDTOs(List<SystemMenuPO> pos);

    MenuTreeBO toMenuBO(SystemMenuPO po);

    List<MenuTreeBO> toMenuBOs(List<SystemMenuPO> po);

    @Mappings({
            @Mapping(target = "crtTm", source = "po.crtTm", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "updTm", source = "po.updTm", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    QueryRoleResponseDTO toQueryRoleResponseDTO(SystemRolePO po);

    List<QueryRoleResponseDTO> toQueryRoleResponseDTOs(List<SystemRolePO> pos);

    @Mappings({
            @Mapping(target = "pkId", expression = "java(IdUtil.getSnowflake().nextIdStr())"),
            @Mapping(target = "isDel", constant = "0")
    })
    SystemRolePO toSystemRolePO(AddRoleBO bo);
}
