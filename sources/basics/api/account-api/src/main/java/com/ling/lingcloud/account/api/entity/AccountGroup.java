package com.ling.lingcloud.account.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ling.lingcloud.common.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 用户组.
 * Class created on 2024/3/22 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
@TableName("account_group")
@EqualsAndHashCode(callSuper = true)
public class AccountGroup extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户组 id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 父 id
     */
    private Long parentId;

    /**
     * parent_list
     */
    private String parentList;

    /**
     * 用户组名称
     */
    private String groupName;

    /**
     * 显示顺序
     */
    private Integer orderNo;
}
