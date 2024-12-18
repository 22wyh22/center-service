package com.wyh.common.exception;

import java.io.Serializable;
import java.util.HashMap;

public final class ErrorCode implements Serializable {

    private static HashMap<String, ErrorCode> errorMap = new HashMap<>();

    public static final ErrorCode OK = registerErrorCode("000000", "OK");
    public static final ErrorCode SERVICE_INNER_ERROR = registerErrorCode("100000", "系统内部异常");
    public static final ErrorCode TOKEN_ERROR = registerErrorCode("100001", "TOKEN过期");
    public static final ErrorCode LOGIN_IP_ERROR = registerErrorCode("100002", "登录被抢占下线");

    private String code;
    private String msg;

    public ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ErrorCode registerToMap(){
        errorMap.put(this.code, this);
        return this;
    }

    public static ErrorCode registerErrorCode(String code, String msg){
        return new ErrorCode(code, msg).registerToMap();
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
