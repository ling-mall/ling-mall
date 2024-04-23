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
 * 基础服务-代码生成-模板分组表 视图类.
 * </p>
 *
 * @author 钟舒艺
 * @since 2024-04-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class FoundationGenerateTemplateGroupVO extends BaseVO implements Serializable {

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
