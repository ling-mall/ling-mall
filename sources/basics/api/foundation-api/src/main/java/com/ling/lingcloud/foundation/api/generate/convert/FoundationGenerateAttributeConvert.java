package com.ling.lingcloud.foundation.api.generate.convert;

import com.ling.lingcloud.common.interfaces.BaseConvert;
import com.ling.lingcloud.foundation.api.generate.dto.FoundationGenerateAttributeDTO;
import com.ling.lingcloud.foundation.api.generate.entity.FoundationGenerateAttribute;
import com.ling.lingcloud.foundation.api.generate.vo.FoundationGenerateAttributeVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 系统用户转换类.
 *
 * @author 钟舒艺
 * @since 2022-10-22 11:09
 **/
@Mapper
public interface FoundationGenerateAttributeConvert extends BaseConvert<FoundationGenerateAttributeVO, FoundationGenerateAttributeDTO, FoundationGenerateAttribute> {

    /**
     * 实例.
     */
    FoundationGenerateAttributeConvert INSTANCE = Mappers.getMapper(FoundationGenerateAttributeConvert.class);
}
