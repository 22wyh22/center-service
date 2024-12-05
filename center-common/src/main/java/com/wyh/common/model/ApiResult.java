package com.wyh.common.model;

import com.wyh.common.exception.ErrorCode;

public final class ApiResult<T> {

    private String msg;
    private String code;
    private T data;

    public static <T> ApiResult<T> ok(T data){
        return new ApiResult<T>().setCode(ErrorCode.OK.getCode()).setMsg(ErrorCode.OK.getMsg()).setData(data);
    }
    public static <T> ApiResult<T> error(ErrorCode error){
        return new ApiResult<T>().setCode(error.getCode()).setMsg(error.getMsg());
    }
    public static <T> ApiResult<T> error(ErrorCode error, String msg){
        return new ApiResult<T>().setCode(error.getCode()).setMsg(msg);
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public ApiResult<T> setData(T data){
        this.data = data;
        return this;
    }
    public ApiResult<T> setMsg(String msg){
        this.msg = msg;
        return this;
    }
    public ApiResult<T> setCode(String code){
        this.code = code;
        return this;
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
