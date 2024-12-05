package com.wyh.application.api.response;

import lombok.Data;

@Data
public class QueryUsersResponseDTO {

    private String pkId;

    private String userId;

    private String userNm;

    private String masterPosition;

    private String slavePosition;

    private String status;

    private String crtBy;

    private String crtTm;
}
