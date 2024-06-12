package com.wyh.application.server;


import com.wyh.application.api.entity.TaskInfo;
import com.wyh.application.api.request.CommAsyncRequestDTO;
import com.wyh.application.assembler.CommAsyncTaskBOAssembler;
import com.wyh.common.exception.AsyncTaskErrorCode;
import com.wyh.common.util.AssertUtil;
import com.wyh.domain.bo.CommAsyncTaskBO;
import com.wyh.domain.service.CommAsyncTaskService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CommAsyncTaskAppService {
    private final static Map<String, TaskInfo> TASK_INFO_MAP = new HashMap<>();

    private final CommAsyncTaskService commAsyncTaskService;

    static {
        TASK_INFO_MAP.put("test", new TaskInfo("class","method"));
    }

    public CommAsyncTaskAppService(CommAsyncTaskService commAsyncTaskService) {
        this.commAsyncTaskService = commAsyncTaskService;
    }

    public Object addCommAsyncTask(CommAsyncRequestDTO commAsyncRequestDTO) {
        TaskInfo info = TASK_INFO_MAP.get(commAsyncRequestDTO.getTaskType());
        AssertUtil.notNull(info, AsyncTaskErrorCode.ASYNC_TASK_PARAM_IS_ERROR, "taskType不存在");
        CommAsyncTaskBO asyncTaskBO = CommAsyncTaskBOAssembler.toCommAsyncTaskBO(commAsyncRequestDTO);
        return commAsyncTaskService.addCommAsyncTask(asyncTaskBO);
    }
}
