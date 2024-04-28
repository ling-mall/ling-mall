package com.ling.lingcloud.account.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ling.lingcloud.common.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 部门表.
 * Class created on 2024/3/11 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
@TableName("account_dept")
@EqualsAndHashCode(callSuper = true)
public class AccountDept extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 父 id.
     */
    private Long parentId;

    /**
     * 部门名称.
     */
    private String deptName;

    /**
     * 显示顺序.
     */
    private Integer orderNo;

    /**
     * 负责人.
     */
    private String leader;

    /**
     * 联系电话.
     */
    private String phone;

    /**
     * 祖级列表.
     */
    private String parentList;

    /**
     * 邮箱.
     */
    private String email;

    /**
     * 部门类型 0:公司 1:部门 2:岗位
     */
    private Integer type;
}
