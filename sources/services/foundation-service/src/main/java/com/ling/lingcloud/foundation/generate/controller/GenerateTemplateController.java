package com.ling.lingcloud.foundation.generate.controller;

import cn.hutool.core.lang.tree.Tree;
import com.ling.lingcloud.common.web.domain.R;
import com.ling.lingcloud.foundation.api.generate.dto.FoundationGenerateTemplateDTO;
import com.ling.lingcloud.foundation.generate.service.IGenerateTemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 模板接口.
 * Class created on 2024/4/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/foundation/generate/template")
@RequiredArgsConstructor
public class GenerateTemplateController {

    private final IGenerateTemplateService generateTemplateService;

    /**
     * 保存模板.
     *
     * @param dto 模板dto
     * @return 是否成功
     */
    @PostMapping
    public R<Void> saveTemplate(@RequestBody FoundationGenerateTemplateDTO dto) {
        return R.isSuccess(generateTemplateService.saveTemplate(dto));
    }

    /**
     * 更新模板.
     *
     * @param dto 模板dto
     * @return 是否成功
     */
    @PutMapping
    public R<Void> updateTemplate(@RequestBody FoundationGenerateTemplateDTO dto) {
        return R.isSuccess(generateTemplateService.updateTemplate(dto));
    }

    /**
     * 删除模板.
     *
     * @param ids 模板id
     * @return 是否成功
     */
    @DeleteMapping
    public R<Void> deleteTemplate(@RequestBody List<Long> ids) {
        return R.isSuccess(generateTemplateService.deleteTemplate(ids));
    }

    /**
     * 获取模板树.
     *
     * @return 模板树
     */
    @GetMapping("/{templateGroupId}/tree")
    public R<List<Tree<Long>>> getTemplateGroupTree(@PathVariable Long templateGroupId) {
        return R.success(generateTemplateService.getTemplateTree(templateGroupId));
    }
}
