package com.ling.lingcloud.foundation.api.generate.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ling.lingcloud.common.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;

/**
 * 基础服务-代码生成-模板表.
 *
 * @author 钟舒艺
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("foundation_generate_template")
public class FoundationGenerateTemplate extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 模板名称.
     */
    private String templateName;

    /**
     * 模板内容.
     */
    private String templateContent;

    /**
     * 模板分组.
     */
    private Long templateGroupId;

    /**
     * 父id.
     */
    private Long parentId;

    /**
     * 父id列表.
     */
    private String parentList;

    /**
     * 排序.
     */
    private Integer orderNo;

    /**
     * 状态（0正常 1停用）.
     */
    private Byte status;

    /**
     * 类型（0模板 1文件夹）.
     */
    private Byte type;
}
