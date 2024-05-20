package com.ling.lingcloud.foundation.generate.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ling.lingcloud.foundation.api.generate.dto.generateentity.FoundationGenerateEntityColumnDTO;
import com.ling.lingcloud.foundation.api.generate.dto.generateentity.FoundationGenerateEntityDTO;
import com.ling.lingcloud.foundation.api.generate.dto.generateentity.FoundationGenerateEntityValueDTO;
import com.ling.lingcloud.foundation.api.generate.entity.FoundationGenerateEntity;
import com.ling.lingcloud.foundation.api.generate.vo.generateentity.FoundationGenerateEntityColumnVO;
import com.ling.lingcloud.foundation.api.generate.vo.generateentity.FoundationGenerateEntityRowVO;
import com.ling.lingcloud.foundation.api.generate.vo.generateentity.FoundationGenerateEntityVO;
import com.ling.lingcloud.foundation.api.generate.vo.generateentity.FoundationGenerateEntityValueVO;
import com.ling.lingcloud.foundation.generate.mapper.GenerateEntityMapper;
import com.ling.lingcloud.foundation.generate.service.IGenerateTemplateEntityService;

import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 模板服务实现.
 * Class created on 2024/4/24 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Service
@RequiredArgsConstructor
public class GenerateTemplateEntityServiceImpl implements IGenerateTemplateEntityService {

    private static final Logger log = LoggerFactory.getLogger(GenerateTemplateEntityServiceImpl.class);
    private final GenerateEntityMapper mapper;

    @Override
    public FoundationGenerateEntityVO getTemplateEntity(Long entityId) {
        FoundationGenerateEntity foundationGenerateEntity = mapper.selectById(entityId);
        FoundationGenerateEntityVO foundationGenerateEntityVO;
        if (foundationGenerateEntity != null) {
            foundationGenerateEntityVO = new FoundationGenerateEntityVO();
            foundationGenerateEntityVO.setEntityName(foundationGenerateEntity.getEntityName());
            List<FoundationGenerateEntityRowVO> rows = mapper.listRowByEntityId(entityId);
            List<FoundationGenerateEntityColumnVO> columns = mapper.listColumnByEntityId(entityId);
            List<FoundationGenerateEntityValueVO> values = mapper.listValueByEntityId(entityId);
            rows.forEach(row -> {
                List<FoundationGenerateEntityValueVO> valuesVoList = values.stream()
                        .filter(value -> value.getRowId().equals(row.getId()))
                        .toList();

                List<FoundationGenerateEntityColumnVO> columnList = new ArrayList<>();
                valuesVoList.forEach(value ->

                        columns.stream()
                                .filter(c -> c.getId().equals(value.getColumnId()))
                                .findFirst()
                                .ifPresent(c -> {
                                    c.setValue(value.getValue());
                                    columnList.add(c);
                                }));
                row.setColumns(columnList);
            });
            foundationGenerateEntityVO.setRows(rows);
            return foundationGenerateEntityVO;
        }
        return new FoundationGenerateEntityVO();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveTemplateEntity(FoundationGenerateEntityDTO foundationGenerateEntityDTO) {
        FoundationGenerateEntity foundationGenerateEntity = new FoundationGenerateEntity();
        foundationGenerateEntity.setEntityName(foundationGenerateEntityDTO.getEntityName());
        if (foundationGenerateEntityDTO.getId() != null) {
            // 删除与该实体有关的数据
            mapper.deleteRowByEntityId(foundationGenerateEntityDTO.getId());
            mapper.deleteColumnByEntityId(foundationGenerateEntityDTO.getId());
            mapper.deleteValueByEntityId(foundationGenerateEntityDTO.getId());

            foundationGenerateEntity.setId(foundationGenerateEntityDTO.getId());
            mapper.updateById(foundationGenerateEntity);
        } else {
            // 插入 后注入id
            mapper.insert(foundationGenerateEntity);
        }

        Long entityId = foundationGenerateEntity.getId();

        Map<String, Long> columnIdMap = new HashMap<>();
        if (foundationGenerateEntityDTO.getRows() != null) {
            foundationGenerateEntityDTO.getRows().forEach(row -> {
                row.setEntityId(entityId);
                mapper.insertRow(row);
                log.info("插入行 Id：{}", row.getId());

                Long rowId = row.getId();
                row.getColumns().forEach(column -> {
                    Long columnsId = columnIdMap.get(column.getColumnName());
                    if (columnsId == null) {
                        FoundationGenerateEntityColumnDTO columnDto = new FoundationGenerateEntityColumnDTO();
                        columnDto.setColumnName(column.getColumnName());
                        columnDto.setEntityId(entityId);
                        columnDto.setOrderNo(column.getOrderNo());
                        columnDto.setIsRequired(column.getIsRequired());
                        mapper.insertColumn(columnDto);
                        columnsId = columnDto.getId();
                        columnIdMap.put(column.getColumnName(), columnsId);
                    }

                    String value = column.getValue();
                    if (StrUtil.isNotEmpty(value)) {
                        FoundationGenerateEntityValueDTO valueDto = new FoundationGenerateEntityValueDTO();
                        valueDto.setEntityId(entityId);
                        valueDto.setColumnId(columnsId);
                        valueDto.setRowId(rowId);
                        valueDto.setValue(value);
                        mapper.insertValue(valueDto);
                    }
                });
            });
        }
        return true;
    }
}
