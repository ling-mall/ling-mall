package com.ling.lingcloud.foundation.generate.controller;

import cn.hutool.core.lang.tree.Tree;
import com.ling.lingcloud.common.web.domain.R;
import com.ling.lingcloud.foundation.api.generate.dto.FoundationGenerateTemplateGroupDTO;
import com.ling.lingcloud.foundation.generate.service.IGenerateTemplateGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2024/4/15 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/foundation/generate/template/group")
@RequiredArgsConstructor
public class FoundationGenerateTemplateGroupController {

    private final IGenerateTemplateGroupService groupService;

    /**
     * 创建模板组.
     *
     * @param dto 模板组信息
     * @return 是否成功
     */
    @PostMapping
    public R<Void> createTemplateGroup(@RequestBody FoundationGenerateTemplateGroupDTO dto) {
        return R.isSuccess(groupService.createTemplateGroup(dto));
    }

    /**
     * 删除模板组.
     *
     * @param ids 模板组id列表
     * @return 是否成功
     */
    @DeleteMapping("/{ids}")
    public R<Void> deleteTemplateGroup(@PathVariable Long[] ids) {
        return R.isSuccess(groupService.deleteTemplateGroupByIds(List.of(ids)));
    }

    /**
     * 更新模板组.
     *
     * @param dto 模板组信息
     * @return 是否成功
     */
    @PutMapping
    public R<Void> updateTemplateGroup(@RequestBody FoundationGenerateTemplateGroupDTO dto) {
        return R.isSuccess(groupService.updateTemplateGroup(dto));
    }
    /**
     * 获取模板组树.
     *
     * @param userId 用户id
     * @return 模板组树
     */
    @GetMapping("/tree/{userId}")
    public R<List<Tree<Long>>> getTemplateGroupTree(@PathVariable Long userId) {
        return R.success(groupService.getTemplateGroupTree(userId));
    }
}
