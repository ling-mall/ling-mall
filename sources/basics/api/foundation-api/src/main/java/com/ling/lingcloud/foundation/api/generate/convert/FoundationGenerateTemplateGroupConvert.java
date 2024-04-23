package com.ling.lingcloud.foundation.api.generate.convert;

import com.ling.lingcloud.common.interfaces.BaseConvert;
import com.ling.lingcloud.foundation.api.generate.dto.FoundationGenerateTemplateGroupDTO;
import com.ling.lingcloud.foundation.api.generate.entity.FoundationGenerateTemplateGroup;
import com.ling.lingcloud.foundation.api.generate.vo.FoundationGenerateTemplateGroupVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 系统用户转换类.
 *
 * @author 钟舒艺
 * @since 2022-10-22 11:09
 **/
@Mapper
public interface FoundationGenerateTemplateGroupConvert extends BaseConvert<FoundationGenerateTemplateGroupVO, FoundationGenerateTemplateGroupDTO, FoundationGenerateTemplateGroup> {

    /**
     * 实例.
     */
    FoundationGenerateTemplateGroupConvert INSTANCE = Mappers.getMapper(FoundationGenerateTemplateGroupConvert.class);
}
