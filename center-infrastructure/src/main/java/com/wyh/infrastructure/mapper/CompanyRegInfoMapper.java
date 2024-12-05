package com.wyh.infrastructure.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wyh.infrastructure.po.CompanyRegInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.ResultHandler;

import java.util.Map;

@Mapper
public interface CompanyRegInfoMapper extends BaseMapper<CompanyRegInfoPO> {

    void queryCompanyResultHandler(ResultHandler<Map<String, Object>> handler);
}
