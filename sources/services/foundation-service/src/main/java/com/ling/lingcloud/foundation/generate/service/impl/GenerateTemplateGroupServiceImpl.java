package com.ling.lingcloud.foundation.generate.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.ling.lingcloud.common.web.exception.WebBusinessException;
import com.ling.lingcloud.foundation.api.generate.convert.FoundationGenerateTemplateGroupConvert;
import com.ling.lingcloud.foundation.api.generate.dto.FoundationGenerateTemplateGroupDTO;
import com.ling.lingcloud.foundation.api.generate.entity.FoundationGenerateTemplateGroup;
import com.ling.lingcloud.foundation.api.generate.enums.FoundationGenerateErrorCodeEnum;
import com.ling.lingcloud.foundation.generate.mapper.GenerateTemplateGroupMapper;
import com.ling.lingcloud.foundation.generate.service.IGenerateTemplateGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 模板组服务实现.
 * Class created on 2024/4/15 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Service
@RequiredArgsConstructor
public class GenerateTemplateGroupServiceImpl implements IGenerateTemplateGroupService {

    private final GenerateTemplateGroupMapper mapper;


    @Override
    public List<Tree<Long>> getTemplateGroupTree(Long userId) {
        //配置
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        // 自定义属性名 都要默认值的
        treeNodeConfig.setWeightKey("order");
        treeNodeConfig.setIdKey("id");

        List<FoundationGenerateTemplateGroup> groupsList = mapper.selectTemplateGroupListByUserId(userId);
        return TreeUtil.build(groupsList, 0L, treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(treeNode.getId());
                    tree.setParentId(treeNode.getParentId());
                    tree.setName(treeNode.getGroupName());
                    tree.putAll(BeanUtil.beanToMap(treeNode));
                });
    }

    @Override
    public Boolean deleteTemplateGroupByIds(List<Long> ids) {
        return mapper.deleteBatchIds(ids) == ids.size();
    }

    @Override
    public Boolean updateTemplateGroup(FoundationGenerateTemplateGroupDTO dto) {
        return mapper.updateById(FoundationGenerateTemplateGroupConvert.INSTANCE.dtoToEntity(dto)) > 0;
    }

    @Override
    public Boolean createTemplateGroup(FoundationGenerateTemplateGroupDTO dto) {
        int i = mapper.checkGroupName(dto.getUserId(), dto.getParentId(), dto.getGroupName());
        if (i > 0) {
            throw new WebBusinessException(FoundationGenerateErrorCodeEnum.GROUP_NAME_REPEAT, dto.getGroupName());
        }
        FoundationGenerateTemplateGroup foundationGenerateTemplateGroup = FoundationGenerateTemplateGroupConvert.INSTANCE.dtoToEntity(dto);
        foundationGenerateTemplateGroup.setCreateBy(1L);
        return mapper.insert(foundationGenerateTemplateGroup) > 0;
    }
}
