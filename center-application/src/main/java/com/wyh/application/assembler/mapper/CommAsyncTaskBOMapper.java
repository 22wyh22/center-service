package com.wyh.application.assembler.mapper;

import com.wyh.application.api.request.CommAsyncRequestDTO;
import com.wyh.domain.bo.CommAsyncTaskBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommAsyncTaskBOMapper {

    CommAsyncTaskBOMapper INSTANCE = Mappers.getMapper(CommAsyncTaskBOMapper.class);

    @Mappings({
            @Mapping(target = "request", expression = "java(com.alibaba.fastjson.JSON.toJSONString(dto.getRequestMap()))"),
            @Mapping(target = "taskStatus", constant = "0"),
            @Mapping(target = "pkId", expression = "java(java.util.UUID.randomUUID().toString())")
    })
    CommAsyncTaskBO toCommAsyncTaskBO(CommAsyncRequestDTO dto);
}
