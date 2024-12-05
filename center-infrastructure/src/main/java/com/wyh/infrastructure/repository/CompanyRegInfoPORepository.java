package com.wyh.infrastructure.repository;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyh.infrastructure.mapper.CompanyRegInfoMapper;
import com.wyh.infrastructure.po.CompanyRegInfoPO;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyRegInfoPORepository extends ServiceImpl<CompanyRegInfoMapper, CompanyRegInfoPO> {

}
