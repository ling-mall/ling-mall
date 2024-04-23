package com.ling.lingcloud.foundation.generate.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ling.lingcloud.foundation.api.generate.entity.FoundationGenerateTemplateGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 基础服务-代码生成-模板分组表 Mapper 接口.
 * </p>
 *
 * @author 钟舒艺
 * @since 2024-04-15
 */
@Mapper
@Repository
public interface GenerateTemplateGroupMapper extends BaseMapper<FoundationGenerateTemplateGroup> {

    /**
     * 根据用户id查询模板分组列表.
     *
     * @param userId 用户id
     * @return 模板分组列表
     */
    List<FoundationGenerateTemplateGroup> selectTemplateGroupListByUserId(Long userId);


    /**
     * 检查是否该目录下存在同名模板分组.
     *
     * @param userId    用户id
     * @param parentId  父id
     * @param groupName 模板分组名称
     * @return 模板分组
     */
    int checkGroupName(@Param("userId") Long userId, @Param("parentId") Long parentId, @Param("groupName") String groupName);

}
