package com.ling.lingcloud.common.domain.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * VO 基类.
 * Class created on 2024/3/18 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键id.
     */
    private Long id;

    /**
     * 删除标志（0 代表未删除， 1 代表删除）.
     */
    private Byte isDeleted;

    /**
     * 创建者.
     */
    private Long createBy;

    /**
     * 创建时间.
     */
    private LocalDateTime createTime;

    /**
     * 更新者.
     */
    private Long updateBy;

    /**
     * 更新时间.
     */
    private LocalDateTime updateTime;

    /**
     * 备注.
     */
    private String remark;
}
