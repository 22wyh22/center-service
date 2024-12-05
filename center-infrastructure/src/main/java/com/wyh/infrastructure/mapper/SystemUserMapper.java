package com.wyh.infrastructure.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyh.application.api.request.QueryUsersRequestDTO;
import com.wyh.application.api.response.QueryUsersResponseDTO;
import com.wyh.infrastructure.po.SystemUserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SystemUserMapper extends BaseMapper<SystemUserPO> {
    /**
     * 全部用户信息
     * @return ApiResult
     */
    IPage<QueryUsersResponseDTO> getUsers(IPage<QueryUsersResponseDTO> page
            , @Param("data") QueryUsersRequestDTO requestDTO);
}
