package com.wyh.common.exception;

import static com.wyh.common.exception.ErrorCode.registerErrorCode;

public class UserErrorCode {


    public static final ErrorCode USER_NOT_EXISTS = registerErrorCode("200000","用户不存在或密码错误");
}
