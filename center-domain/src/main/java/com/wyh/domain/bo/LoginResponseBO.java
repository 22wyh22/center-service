package com.wyh.domain.bo;

import lombok.Data;

@Data
public class LoginResponseBO {

    public LoginResponseBO() {
    }
    public LoginResponseBO(String token, SessionInfoBO sessionInfo) {
        this.token = token;
        this.sessionInfo = sessionInfo;
    }
    private String token;

    private SessionInfoBO sessionInfo;
}
