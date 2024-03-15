package com.ling.lingcloud.common.config.properties;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * app 相关.
 * Class created on 2024/3/15 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
public class AppProperties implements Serializable {

    @Serial
    private static final long serialVersionUID = 7998756149861284263L;

    /**
     * 服务id
     */
    private Integer serviceId;
}
