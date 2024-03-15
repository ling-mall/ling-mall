package com.ling.lingcloud.account.api.dto;

import com.ling.lingcloud.common.validation.ValidationGroups;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 角色数据传输对象.
 * Class created on 2024/3/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data

public class AccountRoleDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id.
     */
    @NotNull(message = "主键不能为空", groups = {ValidationGroups.Edit.class})
    @Min(value = 0, message = "id最低为0", groups = {ValidationGroups.Edit.class})
    private Long id;

    /**
     * 角色名称
     */
    @NotEmpty(message = "{account.role.validation.roleName.empty}:{}")
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

}
