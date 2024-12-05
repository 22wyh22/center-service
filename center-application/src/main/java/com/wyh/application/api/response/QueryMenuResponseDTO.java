package com.wyh.application.api.response;

import lombok.Data;

import java.util.List;

@Data
public class QueryMenuResponseDTO {

    private String menuCode;

    private String menuName;

    private String path;

    private String component;

    private String menuType;

    private String icon;

    private List<QueryMenuResponseDTO> children;
}
