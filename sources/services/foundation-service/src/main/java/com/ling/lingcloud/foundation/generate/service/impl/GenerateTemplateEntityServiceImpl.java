package com.ling.lingcloud.foundation.generate.service.impl;

import com.ling.lingcloud.foundation.api.generate.entity.FoundationGenerateEntity;
import com.ling.lingcloud.foundation.api.generate.vo.generateentity.FoundationGenerateEntityColumnVO;
import com.ling.lingcloud.foundation.api.generate.vo.generateentity.FoundationGenerateEntityRowVO;
import com.ling.lingcloud.foundation.api.generate.vo.generateentity.FoundationGenerateEntityVO;
import com.ling.lingcloud.foundation.api.generate.vo.generateentity.FoundationGenerateEntityValueVO;
import com.ling.lingcloud.foundation.generate.mapper.GenerateEntityMapper;
import com.ling.lingcloud.foundation.generate.service.IGenerateTemplateEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 模板服务实现.
 * Class created on 2024/4/24 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Service
@RequiredArgsConstructor
public class GenerateTemplateEntityServiceImpl implements IGenerateTemplateEntityService {

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
}
