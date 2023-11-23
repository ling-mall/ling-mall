package com.ling.lingcloud.account.service.impl;


import com.ling.lingcloud.account.api.domain.AccountUser;
import com.ling.lingcloud.account.mapper.AccountUserMapper;
import com.ling.lingcloud.account.service.IAccountUserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 账户服务.
 * Class created on 2023/7/8 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Service
@RequiredArgsConstructor
public class AccountUserRepositoryServiceImpl implements IAccountUserService {

    private final AccountUserMapper accountUserMapper;

    @Override
    public AccountUser getUserByUserName(String username) {
        return accountUserMapper.selectUserByUserName(username);
    }


}
