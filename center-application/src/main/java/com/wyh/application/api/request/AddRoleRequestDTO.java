package com.wyh.application.api.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class AddRoleRequestDTO {

    @NotBlank(message = "roleCode不能为空")
    private String roleCode;

    @NotBlank(message = "roleName不能为空")
    private String roleName;

    @Pattern(regexp = "\\b[0-3]\\b", message = "level值不正确")
    @NotBlank(message = "level不能为空")
    private String level;
}
