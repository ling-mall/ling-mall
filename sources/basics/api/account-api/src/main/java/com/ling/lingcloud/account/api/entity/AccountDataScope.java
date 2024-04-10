package com.ling.lingcloud.account.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ling.lingcloud.common.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;

/**
 * 数据权限表.
 *
 * @author 钟舒艺
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("account_data_scope")
public class AccountDataScope extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 权限id.
     */
    private Long authorityId;

    /**
     * 规则名称.
     */
    private String ruleName;

    /**
     * 规则字段.
     */
    private String ruleField;

    /**
     * 条件规则.
     */
    private String conditionRule;

    /**
     * 规则值.
     */
    private String ruleValue;

    /**
     * 状态（1正常 0停用）.
     */
    private Byte status;
}
