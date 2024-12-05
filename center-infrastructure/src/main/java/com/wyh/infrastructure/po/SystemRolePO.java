package com.wyh.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("SYSTEM_ROLE")
@Data
public class SystemRolePO {

    @TableId(type = IdType.ASSIGN_UUID)
    private String pkId;

    private String roleCode;

    private String roleName;

    private String level;

    private String isDel;

    private Date crtTm;

    private String crtBy;

    private Date updTm;

    private String updBy;
}
