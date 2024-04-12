package com.ling.lingcloud.foundation.api.generate.dto.generateentity;

import lombok.Data;

/**
 * 实体值.
 * Class created on 2024/4/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
public class FoundationGenerateEntityValueDTO {

    /**
     * 实体值id.
     */
    private Long id;

    /**
     * 实体id.
     */
    private Long entityId;

    /**
     * 实体列id.
     */
    private Long columnId;

    /**
     * 实体行id
     */
    private Long rowId;

    /**
     * 实体值.
     */
    private String value;
}
