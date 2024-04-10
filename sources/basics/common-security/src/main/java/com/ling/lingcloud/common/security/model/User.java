package com.ling.lingcloud.common.security.model;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * 用户类.
 *
 * @author 钟舒艺
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 844732306134765370L;


    /**
     * 用户id.
     */
    private Long id;

    /**
     * 用户名.
     */
    private String username;

    /**
     * 密码.
     */
    private String password;


    /**
     * 用户状态.
     */
    private Byte status;


}
