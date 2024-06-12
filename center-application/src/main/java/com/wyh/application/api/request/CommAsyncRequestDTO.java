package com.wyh.application.api.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * 异步接口请求类
 */
@Data
public class CommAsyncRequestDTO {

    @NotBlank(message = "taskType不能为空")
    private String taskType;
    private String desc;
    private String classNm;
    private String methodNm;
    private Map<String,Object> requestMap;
    private Integer priority;

}
