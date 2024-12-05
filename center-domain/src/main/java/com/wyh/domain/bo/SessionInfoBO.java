package com.wyh.domain.bo;

import lombok.Data;

import java.util.List;

@Data
public class SessionInfoBO {

    private String userId;

    private String userNm;

    private List<MenuTreeBO> menus;
}
