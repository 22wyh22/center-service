package com.wyh.application.api.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequestDTO {

    @NotBlank(message = "登录ID不能为空")
    private String userId;
    @NotBlank(message = "登录密码不能为空")
    private String password;
}
