package com.ling.lingcloud.common.security.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 用户登录信息.
 *
 * @author 钟舒艺
 **/
@Data
public class LoginBody {
    /**
     * 用户名.
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 用户密码.
     */
    @NotBlank(message = "密码不能为空")
    private String password;
}
