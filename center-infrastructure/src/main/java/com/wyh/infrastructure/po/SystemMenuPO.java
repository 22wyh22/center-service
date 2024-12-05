package com.wyh.infrastructure.po;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("SYSTEM_MENU")
@Data
public class SystemMenuPO {

    @TableId
    private String pkId;

    private String menuCode;

    private String menuName;

    private String parentMenuCode;

    private Integer orderNum;

    private String path;

    private String component;

    private String menuType;

    private String icon;
}
