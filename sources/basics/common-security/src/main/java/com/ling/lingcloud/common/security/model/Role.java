package com.ling.lingcloud.common.security.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/8/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {

    /**
     * 角色id.
     */
    private Long id;


    /**
     * 角色名称.
     */
    private String roleName;

    /**
     * 角色字符串.
     */
    private String roleKey;


    /**
     * 角色状态（1正常 0停用）.
     */
    private Byte status;

    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）.
     */
    private Integer dataScope;
}
