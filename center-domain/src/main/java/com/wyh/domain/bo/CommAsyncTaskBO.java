package com.wyh.domain.bo;

import com.wyh.common.exception.AsyncTaskErrorCode;
import com.wyh.common.exception.BizException;
import com.wyh.common.util.AssertUtil;
import com.wyh.domain.global.SpringContextUtil;
import com.wyh.domain.repository.CommAsyncTaskRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * 异步任务类
 */
@Slf4j
@Data
public class CommAsyncTaskBO implements Runnable,Comparable<CommAsyncTaskBO>{

    private String pkId;
    private String taskStatus;
    private String taskType;
    private String desc;
    private String classNm;
    private String methodNm;
    private String request;
    private String result;
    private Integer priority;

    private CommAsyncTaskRepository commAsyncTaskRepository;

    @Override
    public void run() {
        log.info("异步任务开始执行,优先级:{}", this.priority);
        this.taskStatus = "1";
        commAsyncTaskRepository.editCommAsyncTask(this);
        try {
            Object bean = SpringContextUtil.getApplicationContext().getBean(this.classNm);
            Method method = ReflectionUtils.findMethod(bean.getClass(), this.methodNm, CommAsyncTaskBO.class);
            AssertUtil.notNull(method, AsyncTaskErrorCode.ASYNC_TASK_METHOD_NOT_EXISTS);
            method.setAccessible(true);
            ReflectionUtils.invokeMethod(method, bean, this);
        }catch (Exception ex){
            log.error("异步任务执行异常", ex);
            this.taskStatus = "3";
            commAsyncTaskRepository.editCommAsyncTask(this);
            throw new BizException(AsyncTaskErrorCode.ASYNC_TASK_IS_ERROR);
        }
        log.info("异步任务执行结束");
        this.taskStatus = "2";
        commAsyncTaskRepository.editCommAsyncTask(this);
    }

    @Override
    public int compareTo(@NotNull CommAsyncTaskBO o) {
        return o.priority - this.priority;
    }
}
