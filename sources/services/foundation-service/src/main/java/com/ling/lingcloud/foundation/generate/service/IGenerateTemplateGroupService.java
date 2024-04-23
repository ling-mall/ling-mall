package com.ling.lingcloud.foundation.generate.service;

import cn.hutool.core.lang.tree.Tree;
import com.ling.lingcloud.foundation.api.generate.dto.FoundationGenerateTemplateGroupDTO;

import java.util.List;

/**
 * 模板组服务
 * Class created on 2024/4/15 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface IGenerateTemplateGroupService {

    /**
     * 获取模板组树
     *
     * @return 模板组树
     */
    List<Tree<Long>> getTemplateGroupTree(Long userId);

    /**
     * 删除模板组
     *
     * @param ids 模板组id
     * @return 是否成功
     */
    Boolean deleteTemplateGroupByIds(List<Long> ids);

    /**
     * 更新模板组
     *
     * @param dto 模板组dto
     * @return 是否成功
     */
    Boolean updateTemplateGroup(FoundationGenerateTemplateGroupDTO dto);


    /**
     * 创建模板组
     *
     * @param dto 模板组dto
     * @return 是否成功
     */
    Boolean createTemplateGroup(FoundationGenerateTemplateGroupDTO dto);
}
