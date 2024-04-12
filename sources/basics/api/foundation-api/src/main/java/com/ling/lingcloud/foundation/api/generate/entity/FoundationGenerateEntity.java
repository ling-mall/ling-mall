package com.ling.lingcloud.foundation.api.generate.entity;

import com.ling.lingcloud.common.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 实体.
 * Class created on 2024/4/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FoundationGenerateEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 实体名称.
     */
    private String entityName;
}
