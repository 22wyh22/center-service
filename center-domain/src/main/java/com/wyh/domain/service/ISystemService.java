package com.wyh.domain.service;

import com.wyh.domain.bo.AddRoleBO;
import com.wyh.domain.bo.MenuTreeBO;

import java.util.List;

public interface ISystemService {
    List<MenuTreeBO> getMenuTree(String userId);

    Object addRole(AddRoleBO bo);
}
