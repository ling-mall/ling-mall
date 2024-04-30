package com.ling.lingcloud.foundation.generate.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.ling.lingcloud.foundation.api.generate.convert.FoundationGenerateTemplateConvert;
import com.ling.lingcloud.foundation.api.generate.dto.FoundationGenerateTemplateDTO;
import com.ling.lingcloud.foundation.api.generate.entity.FoundationGenerateTemplate;
import com.ling.lingcloud.foundation.generate.mapper.GenerateTemplateMapper;
import com.ling.lingcloud.foundation.generate.service.IGenerateTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 模板服务实现.
 * Class created on 2024/4/24 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Service
@RequiredArgsConstructor
public class GenerateTemplateServiceImpl implements IGenerateTemplateService {

    private final GenerateTemplateMapper mapper;

    @Override
    public Boolean saveTemplate(FoundationGenerateTemplateDTO dto) {
        return mapper.insert(FoundationGenerateTemplateConvert.INSTANCE.dtoToEntity(dto)) > 0;
    }

    @Override
    public Boolean updateTemplate(FoundationGenerateTemplateDTO dto) {
        return mapper.updateById(FoundationGenerateTemplateConvert.INSTANCE.dtoToEntity(dto)) > 0;
    }

    @Override
    public Boolean deleteTemplate(List<Long> ids) {
        return mapper.deleteBatchIds(ids) == ids.size();
    }

    @Override
    public List<Tree<Long>> getTemplateTree(Long templateGroupId) {
        List<FoundationGenerateTemplate> foundationGenerateTemplates = mapper.listByTemplateGroupId(templateGroupId);
        //配置
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        // 自定义属性名 都要默认值的
        treeNodeConfig.setWeightKey("order");
        treeNodeConfig.setIdKey("id");
        return TreeUtil.build(foundationGenerateTemplates, 0L, treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(treeNode.getId());
                    tree.setParentId(treeNode.getParentId());
                    tree.setName(treeNode.getTemplateName());
                    tree.putAll(BeanUtil.beanToMap(treeNode));
                });
    }

}
