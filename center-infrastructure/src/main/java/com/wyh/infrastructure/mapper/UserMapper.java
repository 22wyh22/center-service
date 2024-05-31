package com.wyh.infrastructure.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wyh.infrastructure.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserPO> {
}
