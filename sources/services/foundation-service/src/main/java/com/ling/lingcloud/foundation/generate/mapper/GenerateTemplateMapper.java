package com.ling.lingcloud.foundation.generate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ling.lingcloud.foundation.api.generate.entity.FoundationGenerateTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 模板 mapper.
 * Class created on 2024/4/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Mapper
@Repository
public interface GenerateTemplateMapper extends BaseMapper<FoundationGenerateTemplate> {

    /**
     * 根据模板组id获取模板列表.
     *
     * @param templateGroupId 模板组id
     * @return 模板列表
     */
    default List<FoundationGenerateTemplate> listByTemplateGroupId(Long templateGroupId) {
        return selectList(
                Wrappers.<FoundationGenerateTemplate>lambdaQuery()
                        .eq(FoundationGenerateTemplate::getTemplateGroupId, templateGroupId)
        );
    }
}
