package com.ling.lingcloud.account.api.vo;

import com.ling.lingcloud.common.domain.base.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 用户视图.
 * Class created on 2024/3/18 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountUserVO extends BaseVO {

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
