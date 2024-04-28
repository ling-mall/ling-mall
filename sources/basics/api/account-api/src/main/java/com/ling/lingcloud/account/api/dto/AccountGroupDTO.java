package com.ling.lingcloud.account.api.dto;

import com.ling.lingcloud.common.domain.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户组 操作类.
 * Class created on 2024/3/18 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountGroupDTO extends BaseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 父 id.
     */
    private Long parentId;

    /**
     * .
     */
    private String parentList;

    /**
     * 用户组名称.
     */
    private String groupName;

    /**
     * 显示顺序.
     */
    private Integer orderNo;

}
