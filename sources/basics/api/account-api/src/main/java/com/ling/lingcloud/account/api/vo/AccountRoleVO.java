package com.ling.lingcloud.account.api.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 角色视图类.
 * Class created on 2024/3/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
public class AccountRoleVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 角色 id
     */
    private Long id;

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
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限 5:仅本人权限）
     */
    private Integer dataScope;

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
