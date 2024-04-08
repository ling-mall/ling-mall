package com.ling.lingcloud.account.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.ling.lingcloud.account.api.entity.AccountUser;
import com.ling.lingcloud.account.mapper.AccountUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2024/3/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@SaIgnore
@Validated
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final AccountUserMapper accountUserMapper;

    @RequestMapping("/test")
    public AccountUser test() {
        return accountUserMapper.selectUserByUserName("admin");
    }
}
