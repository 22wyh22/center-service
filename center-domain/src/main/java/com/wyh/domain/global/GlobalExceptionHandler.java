package com.wyh.domain.global;


import com.wyh.common.exception.BizException;
import com.wyh.common.model.ApiResult;
import com.wyh.common.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ApiResult<Object> bizExceptionHandler(HttpServletRequest req, BizException e){
        log.error("BizException自定义异常,原因:{}", e.getMessage(), e);
        return ApiResult.error(e.getError());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResult<Object> exceptionHandler(HttpServletRequest req, Exception e){
        log.error("非自定义异常,原因:{}", e.getMessage(), e);
        return ApiResult.error(ErrorCode.SERVICE_INNER_ERROR, e.getMessage());
    }
}
