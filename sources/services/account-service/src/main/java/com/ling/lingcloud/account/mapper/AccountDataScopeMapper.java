package com.ling.lingcloud.account.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ling.lingcloud.account.api.entity.AccountDataScope;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 数据权限表 Mapper 接口.
 *
 * @author 钟舒艺
 */
@Mapper
@Repository
public interface AccountDataScopeMapper extends BaseMapper<AccountDataScope> {

}
