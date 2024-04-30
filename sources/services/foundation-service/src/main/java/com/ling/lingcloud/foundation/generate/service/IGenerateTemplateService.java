package com.ling.lingcloud.foundation.generate.service;

import cn.hutool.core.lang.tree.Tree;
import com.ling.lingcloud.foundation.api.generate.dto.FoundationGenerateTemplateDTO;

import java.util.List;

/**
 * 模板服务.
 * Class created on 2024/4/24 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface IGenerateTemplateService {

    /**
     * 保存模板.
     *
     * @param dto 模板数据
     * @return 是否成功
     */
    Boolean saveTemplate(FoundationGenerateTemplateDTO dto);

    /**
     * 更新模板.
     *
     * @param dto 模板数据
     * @return 是否成功
     */
    Boolean updateTemplate(FoundationGenerateTemplateDTO dto);

    /**
     * 删除模板.
     *
     * @param ids 模板id
     * @return 是否成功
     */
    Boolean deleteTemplate(List<Long> ids);

    /**
     * 获取模板树.
     *
     * @param templateGroupId 模板组id
     * @return 模板树
     */
    List<Tree<Long>> getTemplateTree(Long templateGroupId);
}
