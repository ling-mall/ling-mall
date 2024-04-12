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
 * 基础服务-代码生成-属性表 视图类.
 * </p>
 *
 * @author 钟舒艺
 * @since 2024-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class FoundationGenerateAttributeVO extends BaseVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 模板id.
     */
    private Long templateId;

    /**
     * 分组id.
     */
    private Long groupId;

    /**
     * 属性名称.
     */
    private String attributeName;

    /**
     * 属性键.
     */
    private String keyName;

    /**
     * 属性作用域 0：组生效 1：模板生效.
     */
    private Byte scope;

    /**
     * 属性类型 0：字符串 1：数字 2：布尔 4：数组 5：JSON对象字符串 .
     */
    private Byte attributeType;

    /**
     * 属性值.
     */
    private String attributeValue;

}
