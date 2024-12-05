package com.wyh.application.assembler;

import com.wyh.application.api.request.AddRoleRequestDTO;
import com.wyh.application.assembler.mapper.SystemBOMapper;
import com.wyh.domain.bo.AddRoleBO;

public class SystemBOAssembler {

    public static AddRoleBO toAddRoleBO(AddRoleRequestDTO requestDTO) {
        return SystemBOMapper.INSTANCE.toAddRoleBO(requestDTO);
    }
}
