package com.ling.lingcloud.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ling.lingcloud.account.api.entity.AccountRole;
import org.springframework.stereotype.Repository;

/**
 * 角色持久层.
 * Class created on 2024/3/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Repository
public interface AccountRoleMapper extends BaseMapper<AccountRole> {

    /**
     * 设置状态.
     *
     * @param id    角色ID
     * @param state 状态
     * @return 是否成功
     */
    default Boolean setState(Long id, Byte state) {
        return update(
                Wrappers.<AccountRole>lambdaUpdate()
                        .eq(AccountRole::getId, id)
                        .set(AccountRole::getStatus, state))
                > 0;
    }

    /**
     * 通过角色键获取角色.
     *
     * @param key 角色键
     * @return 角色
     */
    default AccountRole getAccountRoleByKey(String key) {
        return selectOne(Wrappers.<AccountRole>lambdaQuery().eq(AccountRole::getRoleKey, key).last("limit 1"));
    }
}
