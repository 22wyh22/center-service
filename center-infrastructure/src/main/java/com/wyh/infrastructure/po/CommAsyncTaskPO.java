package com.wyh.infrastructure.po;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("COMM_ASYNC_TASK")
@Data
public class CommAsyncTaskPO {

    @TableId
    private String pkId;
    private String taskStatus;
    private String taskType;
    private String desc;
    private String classNm;
    private String methodNm;
    private String request;
    private String result;
    private Integer priority;
}
