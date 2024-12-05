package com.wyh.application.api.response;

import com.wyh.domain.bo.SessionInfoBO;
import lombok.Data;

@Data
public class LoginResponseDTO {

    private String token;

    private SessionInfoBO sessionInfo;
}
