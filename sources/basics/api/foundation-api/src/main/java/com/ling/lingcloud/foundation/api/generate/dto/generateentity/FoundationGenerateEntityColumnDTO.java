package com.ling.lingcloud.foundation.api.generate.dto.generateentity;

import lombok.Data;

/**
 * 实体列 DTO.
 * Class created on 2024/4/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
public class FoundationGenerateEntityColumnDTO {

    /**
     * 列id
     */
    private Long id;

    /**
     * 实体id
     */
    private Long entityId;

    /**
     * 列名
     */
    private String columnName;

    /**
     * 排序
     */
    private Integer orderNo;

    /**
     * 是否必填
     */
    private Integer isRequired;
}
