package com.ling.lingcloud.foundation.generate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ling.lingcloud.foundation.api.generate.entity.FoundationGenerateTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 模板 mapper.
 * Class created on 2024/4/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Mapper
@Repository
public interface GenerateTemplateMapper extends BaseMapper<FoundationGenerateTemplate> {
}
