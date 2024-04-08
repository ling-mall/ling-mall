package com.ling.lingcloud.admin.api.vo;

import com.ling.lingcloud.account.api.entity.AccountUser;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 管理员视图对象.
 * Class created on 2024/2/29 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
public class AdminUserVO implements Serializable {

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

    /**
     * 账户信息
     */
    private AccountUser accountUser;
}
