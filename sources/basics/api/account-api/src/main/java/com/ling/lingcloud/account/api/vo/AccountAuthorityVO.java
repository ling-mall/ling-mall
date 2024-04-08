package com.ling.lingcloud.account.api.vo;

import com.ling.lingcloud.common.domain.base.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 权限VO.
 * Class created on 2024/3/22 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountAuthorityVO extends BaseVO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 权限类型.
     */
    private Integer authorityType;

    /**
     * 权限唯一标识.
     */
    private String authorityKey;

    /**
     * 显示顺序.
     */
    private Integer orderNo;

    /**
     * 类型 0授权 1禁用
     */
    private Integer type;

}
