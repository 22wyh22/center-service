package com.wyh.domain.global;


import com.wyh.common.exception.BizException;
import com.wyh.common.util.ApiResult;
import com.wyh.common.util.ErrorCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ApiResult<Object> bizExceptionHandler(HttpServletRequest req, BizException e){
        return ApiResult.error(e.getError());
    }

    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ApiResult<Object> exceptionHandler(HttpServletRequest req, Exception e){
        return ApiResult.error(ErrorCode.SERVICE_INNER_ERROR, e.getMessage());
    }
}
