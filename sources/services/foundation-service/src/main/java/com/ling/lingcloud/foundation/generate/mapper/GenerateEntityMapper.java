package com.ling.lingcloud.foundation.generate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ling.lingcloud.foundation.api.generate.dto.generateentity.FoundationGenerateEntityDTO;
import com.ling.lingcloud.foundation.api.generate.dto.generateentity.FoundationGenerateEntityRowDTO;
import com.ling.lingcloud.foundation.api.generate.entity.FoundationGenerateEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 实体 mapper.
 * Class created on 2024/4/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Mapper
@Repository
public interface GenerateEntityMapper extends BaseMapper<FoundationGenerateEntity> {

    /**
     * 插入行
     *
     * @param dto 行dto
     * @return 插入行数
     */
    int insertRow(FoundationGenerateEntityRowDTO dto);

    /**
     * 删除行
     *
     * @param rowId 行id
     * @return 删除行数
     */
    int deleteRow(Long rowId);

    /**
     * 通过实体id删除行
     *
     * @param entityId 实体id
     * @return 删除行数
     */
    int deleteRowByEntityId(Long entityId);

    /**
     * 删除列
     *
     * @param columnId 列id
     * @return 删除列数
     */
    int deleteColumn(Long columnId);

    /**
     * 通过实体id删除列
     *
     * @param entityId 实体id
     * @return 删除列数
     */
    int deleteColumnByEntityId(Long entityId);

    /**
     * 通过实体id删除值
     *
     * @param valueId 值id
     * @return 删除值数
     */
    int deleteValue(Long valueId);

    /**
     * 通过实体id删除值
     *
     * @param entityId 实体id
     * @return 删除值数
     */
    int deleteValueByEntityId(Long entityId);

    /**
     * 通过行id删除值
     *
     * @param rowId 行id
     * @return 删除值数
     */
    int deleteValueByRowId(Long rowId);

    /**
     * 通过列id删除值
     *
     * @param columnId 列id
     * @return 删除值数
     */
    int deleteValueByColumnId(Long columnId);

}
