package com.wyh.common.exception;

import com.wyh.common.util.ErrorCode;

import static com.wyh.common.util.ErrorCode.registerErrorCode;

public class UserErrorCode {


    public static final ErrorCode USER_EXISTS = registerErrorCode("200000","用户不存在");
}
