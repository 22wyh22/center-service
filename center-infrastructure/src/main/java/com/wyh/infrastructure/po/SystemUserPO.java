package com.wyh.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("SYSTEM_USER")
@Data
public class SystemUserPO {

    @TableId(type = IdType.ASSIGN_UUID)
    private String pkId;

    private String userId;

    private String userNm;

    private String password;

    private String status;
}
