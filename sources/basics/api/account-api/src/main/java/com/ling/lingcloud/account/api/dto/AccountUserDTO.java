package com.ling.lingcloud.account.api.dto;

import com.ling.lingcloud.common.domain.base.BaseDTO;
import com.ling.lingcloud.common.validation.ValidationGroups;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2024/3/18 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountUserDTO extends BaseDTO {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户账号.
     */
    @NotBlank(message = "{account.user.validation.username}:{}", groups = {ValidationGroups.Edit.class, ValidationGroups.Add.class})
    private String username;

    /**
     * 用户邮箱.
     */
    @Email(message = "{account.user.validation.email}:{}", groups = {ValidationGroups.Edit.class, ValidationGroups.Add.class})
    private String email;

    /**
     * 手机号码.
     */
    private String tel;

    /**
     * 密码.
     */
    private String password;

    /**
     * 账号状态（1正常 0停用）.
     */
    private Byte status;

    /**
     * 创建ip.
     */
    private String createIpAt;

    /**
     * 最后一次登录时间.
     */
    private Integer lastLoginAt;

    /**
     * 最后一次登录ip.
     */
    private String lastLoginIpAt;

    /**
     * 登录次数.
     */
    private Integer loginCount;
}
