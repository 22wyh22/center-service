package com.wyh.domain.repository;

import com.wyh.domain.bo.AddRoleBO;
import com.wyh.domain.bo.MenuTreeBO;

import java.util.List;

public interface SystemRepository {

    List<MenuTreeBO> getMenuTree(String userId);

    Object addRole(AddRoleBO bo);
}
