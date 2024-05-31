package com.wyh.application.api.response;

import lombok.Data;

@Data
public class UserLoginResponseDTO {

    private String token;

    private String userId;
}
