package com.wyh.application.api;

import com.wyh.application.api.request.CommAsyncRequestDTO;
import com.wyh.application.server.CommAsyncTaskAppService;
import com.wyh.common.util.ApiResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comm-async-task")
public class CommAsyncTaskController {

    private CommAsyncTaskAppService commAsyncTaskAppService;

    public CommAsyncTaskController(CommAsyncTaskAppService commAsyncTaskAppService) {
        this.commAsyncTaskAppService = commAsyncTaskAppService;
    }

    @PostMapping
    public ApiResult<Object> addCommAsyncTask(@RequestBody @Validated CommAsyncRequestDTO commAsyncRequestDTO){
        return ApiResult.ok(commAsyncTaskAppService.addCommAsyncTask(commAsyncRequestDTO));
    }
}
