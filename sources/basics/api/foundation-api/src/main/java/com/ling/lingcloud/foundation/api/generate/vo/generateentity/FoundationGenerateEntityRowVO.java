package com.ling.lingcloud.foundation.api.generate.vo.generateentity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 行数据.
 * Class created on 2024/4/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
public class FoundationGenerateEntityRowVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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
     * 列信息
     */
    private List<FoundationGenerateEntityColumnVO> columns;
}
