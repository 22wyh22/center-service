package com.wyh.infrastructure.repository;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyh.infrastructure.mapper.GlobalSchoolInfoMapper;
import com.wyh.infrastructure.po.GlobalSchoolInfoPO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GlobalSchoolInfoPORepository extends ServiceImpl<GlobalSchoolInfoMapper, GlobalSchoolInfoPO> {



    public List<Map<String,Object>> queryList(){
        return this.baseMapper.queryList();
    }
}
