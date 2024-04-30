package com.ling.lingcloud.admin.api.entity;

import com.ling.lingcloud.common.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 后台管理员.
 * Class created on 2024/2/29 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AdminUser extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 账户id
     */
    private Long userId;

    /**
     * 真名
     */
    private String realName;

    /**
     * 性别 0：男，1：女
     */
    private Integer gender;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 账号状态（1停用 0正常）
     */
    private Integer status;
}
