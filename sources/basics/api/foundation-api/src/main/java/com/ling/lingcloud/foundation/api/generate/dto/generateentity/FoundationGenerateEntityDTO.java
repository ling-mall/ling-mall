package com.ling.lingcloud.foundation.api.generate.dto.generateentity;

import com.ling.lingcloud.common.domain.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.List;

/**
 * 实体 DTO.
 * Class created on 2024/4/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FoundationGenerateEntityDTO extends BaseDTO {

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
     * 列
     */
    private List<FoundationGenerateEntityColumnDTO> columns;

    /**
     * 行
     */
    private List<FoundationGenerateEntityRowDTO> rows;
}
