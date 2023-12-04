package com.ling.lingcloud.common.security.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/8/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
public class LoginUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID.
     */
    private Long userId;

    /**
     * 用户名.
     */
    private String username;


    /**
     * 用户唯一标识.
     */
    private String token;

    /**
     * 登录时间.
     */
    private Long loginTime;

    /**
     * 过期时间.
     */
    private Long expireTime;

    /**
     * 登录IP地址.
     */
    private String ipaddr;

    /**
     * 登录地点.
     */
    private String loginLocation;

    /**
     * 浏览器类型.
     */
    private String browser;

    /**
     * 操作系统.
     */
    private String os;

    /**
     * 角色对象.
     */
    private List<? extends Role> roles;


}
