package com.ling.lingcloud.foundation.generate.service;

import com.ling.lingcloud.foundation.api.generate.vo.generateentity.FoundationGenerateEntityVO;

/**
 * 模板实体服务.
 * Class created on 2024/4/24 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface IGenerateTemplateEntityService {

    /**
     * 获取模板实体.
     *
     * @param entityId 模板实体id
     * @return 模板实体
     */
    FoundationGenerateEntityVO getTemplateEntity(Long entityId);
}
