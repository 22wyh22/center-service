package com.wyh.domain.repository;

import com.wyh.domain.bo.CommAsyncTaskBO;

public interface CommAsyncTaskRepository {

    void insertCommAsyncTask(CommAsyncTaskBO asyncTaskBO);

    void editCommAsyncTask(CommAsyncTaskBO asyncTaskBO);
}
