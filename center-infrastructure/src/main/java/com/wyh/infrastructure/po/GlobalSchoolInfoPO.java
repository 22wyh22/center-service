package com.wyh.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@TableName("GLOBAL_SCHOOL_INFO")
@Data
public class GlobalSchoolInfoPO {

    @TableId
    private String pkId;
    private String province;
    private String name;
    private String majorType;
    private String type;
    private String schoolType;
    @TableField("is_985")
    private String is985;
    @TableField("is_211")
    private String is211;
    private String isFirst;
    private String city;
    private String subjection;
    private String address;
    private BigDecimal longitude;
    private BigDecimal latitude;

}
