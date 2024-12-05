package com.wyh.application.assembler;

import com.wyh.application.api.request.CommAsyncRequestDTO;
import com.wyh.application.assembler.mapper.CommAsyncTaskBOMapper;
import com.wyh.domain.bo.CommAsyncTaskBO;

public class CommAsyncTaskBOAssembler {


    public static CommAsyncTaskBO toCommAsyncTaskBO(CommAsyncRequestDTO commAsyncRequestDTO){
        return CommAsyncTaskBOMapper.INSTANCE.toCommAsyncTaskBO(commAsyncRequestDTO);
    }
}
