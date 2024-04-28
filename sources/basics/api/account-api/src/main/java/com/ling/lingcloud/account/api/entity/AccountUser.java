package com.ling.lingcloud.account.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ling.lingcloud.common.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * <p>
 * 账户表.
 * </p>
 *
 * @author 钟舒艺
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("account_user")
public class AccountUser extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户账号.
     */
    private String username;

    /**
     * 用户邮箱.
     */
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
    private LocalDateTime lastLoginAt;

    /**
     * 最后一次登录ip.
     */
    private String lastLoginIpAt;

    /**
     * 登录次数.
     */
    private Integer loginCount;
}
