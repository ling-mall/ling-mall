package com.ling.lingcloud.account.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ling.lingcloud.common.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;

/**
 * <p>
 * 第三方用户信息.
 * </p>
 *
 * @author 钟舒艺
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("account_platform")
public class AccountPlatform extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 账号id.
     */
    private Integer userId;

    /**
     * 平台id.
     */
    private String platformId;

    /**
     * 平台access_token.
     */
    private String platformToken;

    /**
     * 平台类型 0:未知,1:facebook,2:google,3:wechat,4:qq,5:weibo,6:twitter.
     */
    private Boolean type;

    /**
     * 昵称.
     */
    private String nickname;

    /**
     * 头像.
     */
    private String avatar;
}
