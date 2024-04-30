package com.ling.lingcloud.foundation.api.generate.vo.generateentity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 实体 DTO.
 * Class created on 2024/4/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
public class FoundationGenerateEntityVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 模板组id
     */
    private Long groupId;

    /**
     * 实体名称
     */
    private String entityName;

    /**
     * 行
     */
    private List<FoundationGenerateEntityRowVO> rows;
}
