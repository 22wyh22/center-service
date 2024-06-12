package com.wyh.common.util;

import com.wyh.common.exception.BizException;

import java.util.List;

public final class AssertUtil {

    public static void notNull(Object input, ErrorCode error){
        if(null == input){
            throw new BizException(error);
        }
    }
    public static void notNull(Object input, ErrorCode error, String message){
        if(null == input){
            throw new BizException(error,message);
        }
    }

    public static void notEmptyList(List input, ErrorCode error){
        if(null == input || input.isEmpty()){
            throw new BizException(error);
        }
    }
}
