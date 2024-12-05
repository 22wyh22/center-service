package com.wyh.infrastructure.persistence;


import com.wyh.domain.bo.CommAsyncTaskBO;
import com.wyh.domain.repository.CommAsyncTaskRepository;
import com.wyh.infrastructure.assembler.CommAsyncTaskPOAssembler;
import com.wyh.infrastructure.po.CommAsyncTaskPO;
import com.wyh.infrastructure.repository.CommAsyncTaskPORepository;
import org.springframework.stereotype.Repository;

@Repository
public class CommAsyncTaskRepositoryImpl implements CommAsyncTaskRepository {

    private CommAsyncTaskPORepository commAsyncTaskPORepository;

    public CommAsyncTaskRepositoryImpl(CommAsyncTaskPORepository commAsyncTaskPORepository) {
        this.commAsyncTaskPORepository = commAsyncTaskPORepository;
    }

    @Override
    public void insertCommAsyncTask(CommAsyncTaskBO asyncTaskBO) {
        CommAsyncTaskPO po = CommAsyncTaskPOAssembler.toCommAsyncTaskPO(asyncTaskBO);
        commAsyncTaskPORepository.getBaseMapper().insert(po);
    }

    @Override
    public void editCommAsyncTask(CommAsyncTaskBO asyncTaskBO) {
        CommAsyncTaskPO po = CommAsyncTaskPOAssembler.toCommAsyncTaskPO(asyncTaskBO);
        commAsyncTaskPORepository.getBaseMapper().updateById(po);
    }
}
