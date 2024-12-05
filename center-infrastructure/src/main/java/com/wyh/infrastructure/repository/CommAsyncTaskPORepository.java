package com.wyh.infrastructure.repository;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyh.infrastructure.mapper.CommAsyncTaskMapper;
import com.wyh.infrastructure.po.CommAsyncTaskPO;
import org.springframework.stereotype.Repository;

@Repository
public class CommAsyncTaskPORepository extends ServiceImpl<CommAsyncTaskMapper, CommAsyncTaskPO> {

}
