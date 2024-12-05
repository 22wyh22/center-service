package com.wyh.infrastructure.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wyh.infrastructure.po.GlobalSchoolInfoPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GlobalSchoolInfoMapper extends BaseMapper<GlobalSchoolInfoPO> {

    List<Map<String, Object>> queryList();
}
