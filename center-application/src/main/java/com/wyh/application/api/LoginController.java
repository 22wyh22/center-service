package com.wyh.application.api;

import com.wyh.application.api.request.LoginRequestDTO;
import com.wyh.application.server.LoginAppService;
import com.wyh.common.model.ApiResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginAppService loginAppService;

    public LoginController(LoginAppService loginAppService) {
        this.loginAppService = loginAppService;
    }

    @PostMapping
    public ApiResult<Object> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ApiResult.ok(loginAppService.login(loginRequestDTO));
    }
}
