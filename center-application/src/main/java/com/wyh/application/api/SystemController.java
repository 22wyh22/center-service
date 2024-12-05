package com.wyh.application.api;


import com.wyh.application.api.request.AddRoleRequestDTO;
import com.wyh.application.api.request.QueryMenuRequestDTO;
import com.wyh.application.api.request.QueryRoleRequestDTO;
import com.wyh.application.api.request.QueryUsersRequestDTO;
import com.wyh.application.server.SystemAppService;
import com.wyh.common.model.ApiResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemController {


    private final SystemAppService systemAppService;

    public SystemController(SystemAppService systemAppService) {
        this.systemAppService = systemAppService;
    }

    /**
     * 全部菜单信息
     * @param requestDTO dto
     * @return ApiResult
     */
    @PostMapping("/menu/tree")
    public ApiResult<Object> getMenuTree(@RequestBody QueryMenuRequestDTO requestDTO){
        return ApiResult.ok(systemAppService.getMenuTree(requestDTO));
    }

    /**
     * 全部用户信息
     * @param requestDTO dto
     * @return ApiResult
     */
    @PostMapping("/users")
    public ApiResult<Object> getMenuTree(@Validated @RequestBody QueryUsersRequestDTO requestDTO){
        return ApiResult.ok(systemAppService.getUsers(requestDTO));
    }

    /**
     * 角色信息
     * @param requestDTO dto
     * @return ApiResult
     */
    @PostMapping("/role/list")
    public ApiResult<Object> queryRoleList(@Validated @RequestBody QueryRoleRequestDTO requestDTO){
        return ApiResult.ok(systemAppService.queryRoleList(requestDTO));
    }
    /**
     * 角色信息-新增
     * @param requestDTO dto
     * @return ApiResult
     */
    @PostMapping("/role/add")
    public ApiResult<Object> addRole(@Validated @RequestBody AddRoleRequestDTO requestDTO){
        return ApiResult.ok(systemAppService.addRole(requestDTO));
    }
}
