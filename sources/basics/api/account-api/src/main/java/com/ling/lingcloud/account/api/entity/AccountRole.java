package com.ling.lingcloud.account.api.entity;

import com.ling.lingcloud.common.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 角色.
 * Class created on 2024/3/11 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountRole extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色权限字符串
     */
    private String roleKey;

    /**
     * 显示顺序
     */
    private Integer orderNo;

    /**
     * 数据权限优先级，数值越小表示优先级越高
     */
    private Integer dataScopePriority;

    /**
     * 角色状态（1 启用 0 禁用）
     */
    private Integer status;

    /**
     * 父id
     */
    private Long parentId;

    /**
     * 父id列表
     */
    private String parentList;

}
