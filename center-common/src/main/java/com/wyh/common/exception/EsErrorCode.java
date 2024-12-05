package com.wyh.common.exception;

import static com.wyh.common.exception.ErrorCode.registerErrorCode;

public class EsErrorCode {


    public static final ErrorCode ES_INDEX_INFO_NOT_EXISTS = registerErrorCode("202000","ES索引配置不存在");

    public static final ErrorCode ASYNC_TASK_PARAM_IS_ERROR = registerErrorCode("201001","异步任务参数错误");

    public static final ErrorCode ASYNC_TASK_IS_ERROR = registerErrorCode("201002","异步任务执行异常");
}
