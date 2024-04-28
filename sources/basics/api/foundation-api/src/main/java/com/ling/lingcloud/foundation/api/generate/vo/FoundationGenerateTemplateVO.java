package com.ling.lingcloud.foundation.api.generate.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ling.lingcloud.common.domain.base.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 基础服务-代码生成-模板表 视图类.
 * </p>
 *
 * @author 钟舒艺
 * @since 2024-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class FoundationGenerateTemplateVO extends BaseVO implements Serializable {

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
