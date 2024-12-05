package com.wyh.infrastructure.repository;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyh.infrastructure.mapper.SystemRoleMapper;
import com.wyh.infrastructure.po.SystemRolePO;
import org.springframework.stereotype.Repository;

@Repository
public class SystemRolePORepository extends ServiceImpl<SystemRoleMapper, SystemRolePO> {

}
