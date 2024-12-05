package com.wyh.infrastructure.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "COMPANY_REG_INFO")
public class CompanyRegInfoPO {
    @TableId(type = IdType.ASSIGN_UUID)
    private String pkId;
    private String name;
    private String code;
    private String regDay;
    private String type;
    private String legalRepresentative;
    private String capital;
    private String businessScope;
    private String province;
    private String city;
    private String address;

}
