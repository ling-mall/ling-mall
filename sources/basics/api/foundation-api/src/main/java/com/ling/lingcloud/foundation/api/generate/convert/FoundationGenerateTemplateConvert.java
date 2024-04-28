package com.ling.lingcloud.foundation.api.generate.convert;

import com.ling.lingcloud.common.interfaces.BaseConvert;
import com.ling.lingcloud.foundation.api.generate.dto.FoundationGenerateTemplateDTO;
import com.ling.lingcloud.foundation.api.generate.entity.FoundationGenerateTemplate;
import com.ling.lingcloud.foundation.api.generate.vo.FoundationGenerateTemplateVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 模板转化接口.
 * Class created on 2024/4/24 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Mapper
public interface FoundationGenerateTemplateConvert extends BaseConvert<FoundationGenerateTemplateVO, FoundationGenerateTemplateDTO, FoundationGenerateTemplate> {
    FoundationGenerateTemplateConvert INSTANCE = Mappers.getMapper(FoundationGenerateTemplateConvert.class);
}
