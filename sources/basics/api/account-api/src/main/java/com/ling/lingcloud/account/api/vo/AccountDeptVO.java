package com.ling.lingcloud.account.api.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ling.lingcloud.common.domain.base.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 部门表 视图类.
 * </p>
 *
 * @author 钟舒艺
 * @since 2024-03-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountDeptVO extends BaseVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 父 id.
     */
    private Long parentId;

    /**
     * 部门名称.
     */
    private String deptName;

    /**
     * 显示顺序.
     */
    private Integer orderNo;

    /**
     * 负责人.
     */
    private String leader;

    /**
     * 联系电话.
     */
    private String phone;

    /**
     * .
     */
    private String parentList;

    /**
     * 邮箱.
     */
    private String email;

}
