package com.ling.lingcloud.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ling.lingcloud.account.api.entity.AccountUser;
import org.springframework.stereotype.Repository;

/**
 * 账户持久层.
 * Class created on 2023/7/7  by 钟舒艺
 *
 * @author 钟舒艺
 */
@Repository
public interface AccountUserMapper extends BaseMapper<AccountUser> {

    /**
     * 根据用户名查询用户信息.
     *
     * @param username 用户名
     * @return 用户信息
     */
    default AccountUser selectUserByUserName(String username) {
        return selectOne(
                Wrappers.<AccountUser>lambdaQuery()
                        .eq(AccountUser::getUsername, username)
                        .last("limit 1"));
    }

}
