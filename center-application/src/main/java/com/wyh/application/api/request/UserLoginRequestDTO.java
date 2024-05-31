package com.wyh.application.api.request;

import lombok.Data;

@Data
public class UserLoginRequestDTO {

    private String userId;

    private String password;
}
