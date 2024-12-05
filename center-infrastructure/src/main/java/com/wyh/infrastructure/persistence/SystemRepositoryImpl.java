package com.wyh.infrastructure.persistence;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyh.application.api.request.QueryRoleRequestDTO;
import com.wyh.application.api.request.QueryUsersRequestDTO;
import com.wyh.application.api.response.QueryRoleResponseDTO;
import com.wyh.application.api.response.QueryUsersResponseDTO;
import com.wyh.application.repository.SystemAppRepository;
import com.wyh.common.model.PageRows;
import com.wyh.common.util.ThreadLocalUtil;
import com.wyh.domain.bo.AddRoleBO;
import com.wyh.domain.bo.MenuTreeBO;
import com.wyh.domain.repository.SystemRepository;
import com.wyh.infrastructure.assembler.SystemPOAssembler;
import com.wyh.infrastructure.po.SystemMenuPO;
import com.wyh.infrastructure.po.SystemRolePO;
import com.wyh.infrastructure.po.SystemUserPO;
import com.wyh.infrastructure.repository.SystemMenuPORepository;
import com.wyh.infrastructure.repository.SystemRolePORepository;
import com.wyh.infrastructure.repository.SystemUserPORepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class SystemRepositoryImpl implements SystemAppRepository, SystemRepository {

    private final SystemMenuPORepository systemMenuPORepository;

    private final SystemUserPORepository systemUserPORepository;

    private final SystemRolePORepository systemRolePORepository;

    public SystemRepositoryImpl(SystemMenuPORepository systemMenuPORepository,
                                SystemUserPORepository systemUserPORepository,
                                SystemRolePORepository systemRolePORepository) {
        this.systemMenuPORepository = systemMenuPORepository;
        this.systemUserPORepository = systemUserPORepository;
        this.systemRolePORepository = systemRolePORepository;
    }

    @Override
    public List<MenuTreeBO> getMenuTree(String userId) {
        List<SystemMenuPO> menus = systemMenuPORepository.getBaseMapper().getMenu(userId);
        List<MenuTreeBO> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(menus)) {
            return list;
        }
        List<SystemMenuPO> root = menus.stream().filter(x -> Objects.isNull(x.getParentMenuCode()))
                .collect(Collectors.toList());
        list.addAll(SystemPOAssembler.toMenuBOs(root));
        this.treeMenu(list, menus);
        return list;
    }


    private void treeMenu(List<MenuTreeBO> list, List<SystemMenuPO> menus) {
        for (MenuTreeBO dto : list) {
            List<SystemMenuPO> collect = menus.stream().filter(x -> dto.getMenuCode().equals(x.getParentMenuCode()))
                    .sorted(Comparator.comparing(SystemMenuPO::getOrderNum))
                    .collect(Collectors.toList());
            if (CollectionUtils.isEmpty(collect)) {
                continue;
            }
            List<MenuTreeBO> dtos = SystemPOAssembler.toMenuBOs(collect);
            dto.setChildren(dtos);
            treeMenu(dtos, menus);
        }
    }

    /**
     * 全部用户信息
     * @return ApiResult
     */
    @Override
    public PageRows<QueryUsersResponseDTO> getUsers(QueryUsersRequestDTO requestDTO) {
        Integer pageNum = requestDTO.getPageNum();
        Integer pageSize = requestDTO.getPageSize();
        IPage<QueryUsersResponseDTO> page = new Page<>(pageNum, pageSize);
        IPage<QueryUsersResponseDTO> result = this.systemUserPORepository.getUsers(page, requestDTO);
        return new PageRows<>(result.getRecords(), result.getTotal(), pageNum, pageSize);
    }

    public List<SystemUserPO> queryUser(String userId) {
        LambdaQueryWrapper<SystemUserPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SystemUserPO::getUserId, userId);
        wrapper.eq(SystemUserPO::getStatus, "0");
        return this.systemUserPORepository.getBaseMapper().selectList(wrapper);
    }

    @Override
    public PageRows<QueryRoleResponseDTO> queryRoleList(QueryRoleRequestDTO requestDTO) {
        LambdaQueryWrapper<SystemRolePO> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotEmpty(requestDTO.getRoleCode()), SystemRolePO::getRoleCode
                , requestDTO.getRoleCode());
        wrapper.like(StringUtils.isNotEmpty(requestDTO.getRoleName()), SystemRolePO::getRoleName
                , requestDTO.getRoleName());
        wrapper.eq(StringUtils.isNotEmpty(requestDTO.getIsDel()), SystemRolePO::getIsDel
                , requestDTO.getIsDel());
        IPage<SystemRolePO> page = new Page<>(requestDTO.getPageNum(), requestDTO.getPageSize());
        IPage<SystemRolePO> result = this.systemRolePORepository.getBaseMapper().selectPage(page, wrapper);
        List<SystemRolePO> records = result.getRecords();
        List<QueryRoleResponseDTO> info = SystemPOAssembler.toQueryRoleResponseDTOs(records);
        return new PageRows<>(info, result.getTotal(), requestDTO.getPageNum(), requestDTO.getPageSize());
    }

    @Override
    public Object addRole(AddRoleBO bo) {
        String userId = (String) ThreadLocalUtil.get("userId");
        Date date = new Date();
        SystemRolePO po = SystemPOAssembler.toSystemRolePO(bo);
        po.setCrtBy(userId);
        po.setUpdBy(userId);
        po.setCrtTm(date);
        po.setUpdTm(date);
        return this.systemRolePORepository.save(po);
    }
}
