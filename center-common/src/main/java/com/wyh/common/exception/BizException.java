package com.wyh.common.exception;

import org.apache.commons.lang3.StringUtils;

public class BizException extends RuntimeException{

    private ErrorCode error;


    public BizException(ErrorCode error) {
        super(error.getMsg());
        this.error = error;
    }

    public BizException(ErrorCode error,String message) {
        super(StringUtils.isBlank(message)? error.getMsg(): message);
        this.error = error;
    }


    public BizException(ErrorCode error, String message, Throwable cause) {
        super(StringUtils.isBlank(message)? error.getMsg(): message, cause);
        this.error = error;
    }

    public BizException(ErrorCode error, Throwable cause) {
        super(error.getMsg(), cause);
    }

    public ErrorCode getError() {
        return error;
    }
}
