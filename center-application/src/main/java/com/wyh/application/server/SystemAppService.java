package com.wyh.application.server;


import com.wyh.application.api.request.AddRoleRequestDTO;
import com.wyh.application.api.request.QueryMenuRequestDTO;
import com.wyh.application.api.request.QueryRoleRequestDTO;
import com.wyh.application.api.request.QueryUsersRequestDTO;
import com.wyh.application.api.response.QueryRoleResponseDTO;
import com.wyh.application.api.response.QueryUsersResponseDTO;
import com.wyh.application.assembler.SystemBOAssembler;
import com.wyh.application.repository.SystemAppRepository;
import com.wyh.common.model.PageRows;
import com.wyh.domain.bo.AddRoleBO;
import com.wyh.domain.bo.MenuTreeBO;
import com.wyh.domain.service.ISystemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemAppService {


    private final SystemAppRepository systemAppRepository;

    private final ISystemService iSystemService;

    public SystemAppService(SystemAppRepository systemAppRepository,
                            ISystemService iSystemService) {
        this.systemAppRepository = systemAppRepository;
        this.iSystemService = iSystemService;
    }

    public List<MenuTreeBO> getMenuTree(QueryMenuRequestDTO queryMenuRequestDTO) {
        return iSystemService.getMenuTree(queryMenuRequestDTO.getUserId());
    }

    /**
     * 全部用户信息
     * @return ApiResult
     */
    public PageRows<QueryUsersResponseDTO> getUsers(QueryUsersRequestDTO requestDTO) {
        return systemAppRepository.getUsers(requestDTO);
    }

    public PageRows<QueryRoleResponseDTO> queryRoleList(QueryRoleRequestDTO requestDTO) {
        return systemAppRepository.queryRoleList(requestDTO);
    }

    public Object addRole(AddRoleRequestDTO requestDTO) {
        AddRoleBO bo = SystemBOAssembler.toAddRoleBO(requestDTO);
        return iSystemService.addRole(bo);
    }
}
