package com.wyh.infrastructure.assembler.mapper;

import com.wyh.domain.bo.CommAsyncTaskBO;
import com.wyh.infrastructure.po.CommAsyncTaskPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommAsyncTaskPOMapper {

    CommAsyncTaskPOMapper INSTANCE = Mappers.getMapper(CommAsyncTaskPOMapper.class);

    CommAsyncTaskPO toCommAsyncTaskPO(CommAsyncTaskBO commAsyncTaskBO);
}
