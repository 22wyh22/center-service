package com.wyh.infrastructure.assembler;

import com.wyh.domain.bo.CommAsyncTaskBO;
import com.wyh.infrastructure.assembler.mapper.CommAsyncTaskPOMapper;
import com.wyh.infrastructure.po.CommAsyncTaskPO;

public class CommAsyncTaskPOAssembler {

    public static CommAsyncTaskPO toCommAsyncTaskPO(CommAsyncTaskBO commAsyncTaskBO){
        return CommAsyncTaskPOMapper.INSTANCE.toCommAsyncTaskPO(commAsyncTaskBO);
    }

}
