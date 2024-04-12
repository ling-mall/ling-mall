package com.ling.lingcloud.foundation.generate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ling.lingcloud.foundation.api.generate.entity.FoundationGenerateAttribute;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 生成属性  Mapper.
 * Class created on 2024/4/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Mapper
@Repository
public interface GenerateAttributeMapper extends BaseMapper<FoundationGenerateAttribute> {
}
