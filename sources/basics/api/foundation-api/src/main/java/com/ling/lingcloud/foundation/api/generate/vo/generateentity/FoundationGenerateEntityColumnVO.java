package com.ling.lingcloud.foundation.api.generate.vo.generateentity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 实体列 DTO.
 * Class created on 2024/4/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
public class FoundationGenerateEntityColumnVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 列id
     */
    private Long id;

    /**
     * 列名
     */
    private String columnName;


    /**
     * 排序
     */
    private Integer orderNo;

    /**
     * 值
     */
    private String value;

    /**
     * 是否必填
     */
    private Integer isRequired;
}
