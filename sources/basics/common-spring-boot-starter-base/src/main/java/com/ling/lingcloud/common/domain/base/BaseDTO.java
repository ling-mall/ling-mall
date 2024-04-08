package com.ling.lingcloud.common.domain.base;

import com.ling.lingcloud.common.validation.ValidationGroups;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 数据传输对象 基类.
 * Class created on 2024/3/18 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
public class BaseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id.
     */
    @NotNull(message = "{common.base.validation.id}:{}", groups = {ValidationGroups.Edit.class})
    @Min(value = 0, message = "{common.base.validation.id}:{}", groups = {ValidationGroups.Edit.class})
    private Long id;
}
