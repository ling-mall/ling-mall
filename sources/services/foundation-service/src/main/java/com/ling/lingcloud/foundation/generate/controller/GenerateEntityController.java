package com.ling.lingcloud.foundation.generate.controller;

import com.ling.lingcloud.common.web.domain.R;
import com.ling.lingcloud.foundation.api.generate.dto.generateentity.FoundationGenerateEntityDTO;
import com.ling.lingcloud.foundation.api.generate.vo.generateentity.FoundationGenerateEntityVO;
import com.ling.lingcloud.foundation.generate.service.IGenerateTemplateEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * 获取实体.
     *
     * @param id 实体id
     * @return 实体
     */
    @GetMapping("/{id}")
    public R<FoundationGenerateEntityVO> getTemplateEntity(@PathVariable Long id) {
        return R.success(generatorTemplateEntityService.getTemplateEntity(id));
    }

    /**
     * 保存实体.
     *
     * @param dto 实体
     * @return 是否成功
     */
    @PostMapping
    public R<Void> saveTemplateEntity(@RequestBody FoundationGenerateEntityDTO dto) {
        return R.isSuccess(generatorTemplateEntityService.saveTemplateEntity(dto));
    }

}
