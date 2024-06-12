package com.wyh.domain.service.impl;

import com.wyh.domain.bo.CommAsyncTaskBO;
import com.wyh.domain.repository.CommAsyncTaskRepository;
import com.wyh.domain.service.CommAsyncTaskService;
import org.springframework.stereotype.Service;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class CommAsyncTaskServiceImpl implements CommAsyncTaskService {

    private ThreadPoolExecutor threadPoolExecutor;

    private CommAsyncTaskRepository commAsyncTaskRepository;

    public CommAsyncTaskServiceImpl(CommAsyncTaskRepository commAsyncTaskRepository) {
        this.commAsyncTaskRepository = commAsyncTaskRepository;
        init();
    }

    private void init(){
        this.threadPoolExecutor = new ThreadPoolExecutor(3, 3, 10,
                TimeUnit.SECONDS, new PriorityBlockingQueue<>(10));
    }

    @Override
    public Object addCommAsyncTask(CommAsyncTaskBO asyncTaskBO) {
        commAsyncTaskRepository.insertCommAsyncTask(asyncTaskBO);
        threadPoolExecutor.execute(asyncTaskBO);
        return true;
    }
}
