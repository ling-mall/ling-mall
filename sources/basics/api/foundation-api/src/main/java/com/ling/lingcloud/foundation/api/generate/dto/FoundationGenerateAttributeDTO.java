package com.ling.lingcloud.foundation.api.generate.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ling.lingcloud.common.domain.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 基础服务-代码生成-属性表 操作类.
 * </p>
 *
 * @author 钟舒艺
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoundationGenerateAttributeDTO extends BaseDTO implements Serializable {

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
