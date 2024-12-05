package com.wyh.infrastructure.repository;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyh.application.api.request.QueryUsersRequestDTO;
import com.wyh.application.api.response.QueryUsersResponseDTO;
import com.wyh.infrastructure.mapper.SystemUserMapper;
import com.wyh.infrastructure.po.SystemUserPO;
import org.springframework.stereotype.Repository;

@Repository
public class SystemUserPORepository extends ServiceImpl<SystemUserMapper, SystemUserPO> {

    /**
     * 全部用户信息
     * @return ApiResult
     */
    public IPage<QueryUsersResponseDTO> getUsers(IPage<QueryUsersResponseDTO> page, QueryUsersRequestDTO requestDTO) {
        return this.baseMapper.getUsers(page, requestDTO);
    }
}
