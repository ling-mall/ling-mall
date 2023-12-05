package com.ling.lingcloud.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/12/5 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
@AllArgsConstructor
public class Demo {

    @NotNull(message = "{validation.id}：{}")
    private Integer id;
}
