package com.wyh.domain.service.impl;

import com.wyh.domain.bo.AddRoleBO;
import com.wyh.domain.bo.MenuTreeBO;
import com.wyh.domain.repository.SystemRepository;
import com.wyh.domain.service.ISystemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemService implements ISystemService {

    private final SystemRepository systemRepository;

    public SystemService(SystemRepository systemRepository) {
        this.systemRepository = systemRepository;
    }

    @Override
    public List<MenuTreeBO> getMenuTree(String userId) {
        return systemRepository.getMenuTree(userId);
    }

    @Override
    public Object addRole(AddRoleBO bo) {
        return systemRepository.addRole(bo);
    }
}
