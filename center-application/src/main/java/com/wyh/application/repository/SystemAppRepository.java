package com.wyh.application.repository;

import com.wyh.application.api.request.QueryRoleRequestDTO;
import com.wyh.application.api.request.QueryUsersRequestDTO;
import com.wyh.application.api.response.QueryRoleResponseDTO;
import com.wyh.application.api.response.QueryUsersResponseDTO;
import com.wyh.common.model.PageRows;

public interface SystemAppRepository {

    /**
     * 全部用户信息
     * @return ApiResult
     */
    PageRows<QueryUsersResponseDTO> getUsers(QueryUsersRequestDTO requestDTO);

    PageRows<QueryRoleResponseDTO> queryRoleList(QueryRoleRequestDTO requestDTO);
}
