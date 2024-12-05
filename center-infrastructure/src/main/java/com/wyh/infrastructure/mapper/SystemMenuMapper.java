package com.wyh.infrastructure.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wyh.infrastructure.po.SystemMenuPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemMenuMapper extends BaseMapper<SystemMenuPO> {


    List<SystemMenuPO> getMenu(@Param("userId") String userId);
}
