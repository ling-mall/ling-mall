package com.ling.lingcloud.foundation.generate.controller;

import com.ling.lingcloud.foundation.generate.service.IGenerateTemplateEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实体控制层.
 * Class created on 2024/3/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/foundation/generate/entity")
@RequiredArgsConstructor
public class GenerateEntityController {

    private final IGenerateTemplateEntityService generatorTemplateEntityService;

    @GetMapping("/{id}")
    public String getTemplateEntity(@PathVariable Long id) {
        return "ok";
    }


}
