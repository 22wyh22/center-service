package com.wyh.application.api.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class QueryUsersRequestDTO {

    private String userId;

    private String userNm;

    private String status;

    @NotNull(message = "分页序号不能为NULL")
    private Integer pageNum;

    @NotNull(message = "分页大小不能为NULL")
    private Integer pageSize;
}
