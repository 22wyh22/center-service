package com.wyh.application.api;

import com.wyh.application.api.request.UserLoginRequestDTO;
import com.wyh.application.server.UserLoginAppService;
import com.wyh.common.util.ApiResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UserLoginController {

    private UserLoginAppService userLoginAppService;

    public UserLoginController(UserLoginAppService userLoginAppService) {
        this.userLoginAppService = userLoginAppService;
    }

    @PostMapping
    public ApiResult<Object> login(@RequestBody UserLoginRequestDTO userLoginRequestDTO){
        return ApiResult.ok(userLoginAppService.login(userLoginRequestDTO));
    }
}
