package com.ling.lingcloud.foundation.generate.service.impl;

import com.ling.lingcloud.foundation.api.generate.entity.FoundationGenerateEntity;
import com.ling.lingcloud.foundation.api.generate.vo.generateentity.FoundationGenerateEntityColumnVO;
import com.ling.lingcloud.foundation.api.generate.vo.generateentity.FoundationGenerateEntityRowVO;
import com.ling.lingcloud.foundation.api.generate.vo.generateentity.FoundationGenerateEntityVO;
import com.ling.lingcloud.foundation.api.generate.vo.generateentity.FoundationGenerateEntityValueVO;
import com.ling.lingcloud.foundation.generate.mapper.GenerateEntityMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * 模板服务实现单元测试.
 * Class created on 2024/4/25 by 钟舒艺
 *
 * @author 钟舒艺
 */
@ExtendWith(MockitoExtension.class)
class GenerateTemplateEntityServiceImplTest {

    @Mock
    GenerateEntityMapper mapper;
    @InjectMocks
    GenerateTemplateEntityServiceImpl generateTemplateEntityServiceImpl;


    @Test
    void testGetTemplateEntity() {
        FoundationGenerateEntity foundationGenerateEntity = new FoundationGenerateEntity();
        foundationGenerateEntity.setId(1L);
        foundationGenerateEntity.setEntityName("User");
        when(mapper.selectById(any(Serializable.class))).thenReturn(foundationGenerateEntity);

        FoundationGenerateEntityRowVO foundationGenerateEntityRowVO = new FoundationGenerateEntityRowVO();
        foundationGenerateEntityRowVO.setId(1L);
        foundationGenerateEntityRowVO.setIndex(1L);
        foundationGenerateEntityRowVO.setEntityId(1L);
        when(mapper.listRowByEntityId(anyLong())).thenReturn(List.of(foundationGenerateEntityRowVO));

        FoundationGenerateEntityColumnVO foundationGenerateEntityColumnVO = new FoundationGenerateEntityColumnVO();
        foundationGenerateEntityColumnVO.setId(1L);
        foundationGenerateEntityColumnVO.setColumnName("mysqlColumnName");
        foundationGenerateEntityColumnVO.setIsRequired(0);
        when(mapper.listColumnByEntityId(anyLong())).thenReturn(List.of(foundationGenerateEntityColumnVO));

        FoundationGenerateEntityValueVO foundationGenerateEntityValueVO = new FoundationGenerateEntityValueVO();
        foundationGenerateEntityValueVO.setId(1L);
        foundationGenerateEntityValueVO.setValue("user_name");
        foundationGenerateEntityValueVO.setColumnId(1L);
        foundationGenerateEntityValueVO.setRowId(1L);
        when(mapper.listValueByEntityId(anyLong())).thenReturn(List.of(foundationGenerateEntityValueVO));


        FoundationGenerateEntityVO result = generateTemplateEntityServiceImpl.getTemplateEntity(1L);
        FoundationGenerateEntityVO foundationGenerateEntityVO = new FoundationGenerateEntityVO();
        foundationGenerateEntityVO.setGroupId(null);
        foundationGenerateEntityVO.setEntityName("User");
        List<FoundationGenerateEntityRowVO> rows = new ArrayList<>();
        FoundationGenerateEntityRowVO row = new FoundationGenerateEntityRowVO();
        row.setId(1L);
        row.setIndex(1L);
        row.setEntityId(1L);
        List<FoundationGenerateEntityColumnVO> columns = new ArrayList<>();
        FoundationGenerateEntityColumnVO column = new FoundationGenerateEntityColumnVO();
        column.setId(1L);
        column.setColumnName("mysqlColumnName");
        column.setValue("user_name");
        column.setIsRequired(0);
        columns.add(column);
        row.setColumns(columns);
        rows.add(row);
        foundationGenerateEntityVO.setRows(rows);
        Assertions.assertEquals(foundationGenerateEntityVO, result);
    }


    public static void main(String[] args) {

    }
}

