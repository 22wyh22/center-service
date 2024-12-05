package com.wyh.infrastructure.assembler;

import com.wyh.application.api.response.QueryMenuResponseDTO;
import com.wyh.application.api.response.QueryRoleResponseDTO;
import com.wyh.domain.bo.AddRoleBO;
import com.wyh.domain.bo.MenuTreeBO;
import com.wyh.infrastructure.assembler.mapper.SystemPOMapper;
import com.wyh.infrastructure.po.SystemMenuPO;
import com.wyh.infrastructure.po.SystemRolePO;

import java.util.List;

public class SystemPOAssembler {

    public static List<QueryMenuResponseDTO> toQueryMenuResponseDTOs(List<SystemMenuPO> po){
        return SystemPOMapper.INSTANCE.toQueryMenuResponseDTOs(po);
    }

    public static List<MenuTreeBO> toMenuBOs(List<SystemMenuPO> po){
        return SystemPOMapper.INSTANCE.toMenuBOs(po);
    }

    public static List<QueryRoleResponseDTO> toQueryRoleResponseDTOs(List<SystemRolePO> pos) {
        return SystemPOMapper.INSTANCE.toQueryRoleResponseDTOs(pos);
    }

    public static SystemRolePO toSystemRolePO(AddRoleBO bo) {
        return SystemPOMapper.INSTANCE.toSystemRolePO(bo);
    }
}