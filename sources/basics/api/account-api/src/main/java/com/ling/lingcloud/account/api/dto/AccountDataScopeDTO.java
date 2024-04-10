package com.ling.lingcloud.account.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ling.lingcloud.common.domain.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 数据权限表 操作类.
 * </p>
 *
 * @author 钟舒艺
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDataScopeDTO extends BaseDTO implements Serializable {

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
