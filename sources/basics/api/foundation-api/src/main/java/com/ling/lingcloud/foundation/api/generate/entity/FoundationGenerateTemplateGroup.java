package com.ling.lingcloud.foundation.api.generate.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ling.lingcloud.common.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;

/**
 * <p>
 * 基础服务-代码生成-模板分组表.
 * </p>
 *
 * @author 钟舒艺
 * @since 2024-04-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("foundation_generate_template_group")
public class FoundationGenerateTemplateGroup extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 分组名称.
     */
    private String groupName;

    /**
     * 父分组id.
     */
    private Long parentId;

    /**
     * 父分组id列表.
     */
    private String parentList;

    /**
     * 排序.
     */
    private Integer orderNo;

    /**
     * 类型（0 文件夹 1 模板组）.
     */
    private Byte type;

    /**
     * 用户id.
     */
    private Long userId;
}
