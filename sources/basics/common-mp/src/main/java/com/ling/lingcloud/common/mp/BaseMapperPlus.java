package com.ling.lingcloud.common.mp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.toolkit.Db;

import java.util.Collection;

/**
 * 增强 BaseMapper.
 * Class created on 2023/10/19 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface BaseMapperPlus<T> extends BaseMapper<T> {


    /**
     * 批量插入
     *
     * @param entityList 实体集合
     * @return 是否成功
     */
    default boolean insertBatch(Collection<T> entityList) {
        return Db.saveBatch(entityList);
    }
}
