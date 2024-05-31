package com.wyh.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("USER")
@Data
public class UserPO {

    @TableId(type = IdType.ASSIGN_UUID)
    private String pkId;

    private String userId;

    private String password;
}
