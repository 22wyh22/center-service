package com.wyh.domain.bo;

import lombok.Data;

import java.util.List;

@Data
public class MenuTreeBO {

    private String menuCode;

    private String menuName;

    private String path;

    private String component;

    private String menuType;

    private String icon;

    private List<MenuTreeBO> children;
}
