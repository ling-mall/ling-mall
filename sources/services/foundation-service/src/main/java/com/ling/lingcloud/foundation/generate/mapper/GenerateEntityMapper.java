package com.ling.lingcloud.foundation.generate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ling.lingcloud.foundation.api.generate.dto.generateentity.FoundationGenerateEntityColumnDTO;
import com.ling.lingcloud.foundation.api.generate.dto.generateentity.FoundationGenerateEntityRowDTO;
import com.ling.lingcloud.foundation.api.generate.dto.generateentity.FoundationGenerateEntityValueDTO;
import com.ling.lingcloud.foundation.api.generate.entity.FoundationGenerateEntity;
import com.ling.lingcloud.foundation.api.generate.vo.generateentity.FoundationGenerateEntityColumnVO;
import com.ling.lingcloud.foundation.api.generate.vo.generateentity.FoundationGenerateEntityRowVO;
import com.ling.lingcloud.foundation.api.generate.vo.generateentity.FoundationGenerateEntityValueVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
     * 获取行
     *
     * @param entityId 实体id
     * @return 行
     */
    List<FoundationGenerateEntityRowVO> listRowByEntityId(Long entityId);


    /**
     * 获取列
     *
     * @param entityId 实体id
     * @return 列
     */
    List<FoundationGenerateEntityColumnVO> listColumnByEntityId(Long entityId);


    /**
     * 获取值
     *
     * @param entityId 实体id
     * @return 值
     */
    List<FoundationGenerateEntityValueVO> listValueByEntityId(Long entityId);

    /**
     * 插入行
     *
     * @param dto 行dto
     * @return 插入行数
     */
    int insertRow(FoundationGenerateEntityRowDTO dto);

    /**
     * 插入列
     *
     * @param dto 列dto
     * @return 插入列数
     */
    int insertColumn(FoundationGenerateEntityColumnDTO dto);


    /**
     * 插入值
     *
     * @param dto 值dto
     * @return 插入值数
     */
    int insertValue(FoundationGenerateEntityValueDTO dto);

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
