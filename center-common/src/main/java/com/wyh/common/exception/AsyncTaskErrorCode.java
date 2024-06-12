package com.wyh.common.exception;

import com.wyh.common.util.ErrorCode;

import static com.wyh.common.util.ErrorCode.registerErrorCode;

public class AsyncTaskErrorCode {


    public static final ErrorCode ASYNC_TASK_METHOD_NOT_EXISTS = registerErrorCode("201000","异步任务对应的业务方法不存在");

    public static final ErrorCode ASYNC_TASK_PARAM_IS_ERROR = registerErrorCode("201001","异步任务参数错误");

    public static final ErrorCode ASYNC_TASK_IS_ERROR = registerErrorCode("201002","异步任务执行异常");
}
