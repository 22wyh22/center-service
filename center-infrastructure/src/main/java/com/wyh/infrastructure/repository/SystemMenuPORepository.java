package com.wyh.infrastructure.repository;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyh.infrastructure.mapper.SystemMenuMapper;
import com.wyh.infrastructure.po.SystemMenuPO;
import org.springframework.stereotype.Repository;

@Repository
public class SystemMenuPORepository extends ServiceImpl<SystemMenuMapper, SystemMenuPO> {

}
