package com.ling.lingcloud.foundation.api.generate.dto.generateentity;

import lombok.Data;

import java.util.List;

/**
 * 行数据.
 * Class created on 2024/4/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
public class FoundationGenerateEntityRowDTO {

    /**
     * 行id
     */
    private Long id;

    /**
     * 行索引
     */
    private Long index;

    /**
     * 实体id
     */
    private Long entityId;

    /**
     * 值列表
     */
    private List<FoundationGenerateEntityValueDTO> values;
}
