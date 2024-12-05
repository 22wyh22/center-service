package com.wyh.application.api.response;

import lombok.Data;

@Data
public class QueryRoleResponseDTO {

    private String pkId;

    private String roleCode;

    private String roleName;

    private String level;

    private String isDel;

    private String crtTm;

    private String crtBy;

    private String updTm;

    private String updBy;
}
