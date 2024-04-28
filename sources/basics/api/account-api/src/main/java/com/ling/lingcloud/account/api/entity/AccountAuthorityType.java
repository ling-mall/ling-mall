package com.ling.lingcloud.account.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ling.lingcloud.common.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2024/3/11 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("account_authority_type")
public class AccountAuthorityType extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 权限类型.
     */
    private Integer authorityType;

    /**
     * 显示顺序.
     */
    private Integer orderNo;
}
