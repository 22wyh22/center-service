package com.wyh.infrastructure.repository;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyh.infrastructure.mapper.UserMapper;
import com.wyh.infrastructure.po.UserPO;
import org.springframework.stereotype.Repository;

@Repository
public class UserPORepository extends ServiceImpl<UserMapper, UserPO> {

}
