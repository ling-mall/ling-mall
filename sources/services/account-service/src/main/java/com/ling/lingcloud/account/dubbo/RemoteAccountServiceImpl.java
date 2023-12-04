package com.ling.lingcloud.account.dubbo;


import com.ling.lingcloud.account.api.RemoteAccountService;
import com.ling.lingcloud.account.api.domain.AccountUser;
import com.ling.lingcloud.account.api.enums.UserErrorCodeEnum;
import com.ling.lingcloud.account.constant.AccountConstant;
import com.ling.lingcloud.account.service.IAccountUserService;
import com.ling.lingcloud.common.exception.BusinessException;
import com.ling.lingcloud.common.security.model.LoginUser;
import com.ling.lingcloud.common.security.service.SecurityService;

import cn.hutool.core.date.DateUtil;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2023/8/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Service
@DubboService
@RequiredArgsConstructor
public class RemoteAccountServiceImpl implements RemoteAccountService {

    private final IAccountUserService accountUserService;

    private final SecurityService securityService;


    @Override
    public String loginByUsername(String username, String password) {
        AccountUser accountUser = accountUserService.getUserByUserName(username);
        // 没有这个用户
        if (accountUser == null) {
            throw new BusinessException(UserErrorCodeEnum.PASSWORD_NOT_MATCH);
        }
        // 密码错误
        if (!securityService.checkPassword(password, accountUser.getPassword())) {
            throw new BusinessException(UserErrorCodeEnum.PASSWORD_NOT_MATCH);
        }
        // 用户被禁用
        if (accountUser.getStatus().equals(AccountConstant.UserStatus.DISABLE)) {
            throw new BusinessException(UserErrorCodeEnum.USER_DISABLED, username);
        }

        LoginUser loginUser = new LoginUser();

        loginUser.setLoginTime(DateUtil.current());
        loginUser.setUserId(accountUser.getId());
        loginUser.setUsername(accountUser.getUsername());

        // 登录
        securityService.login(loginUser);

        return securityService.getToken();
    }
}
