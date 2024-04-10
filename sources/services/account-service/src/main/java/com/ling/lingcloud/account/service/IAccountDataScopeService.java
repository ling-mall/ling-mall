package com.ling.lingcloud.account.service;


import com.ling.lingcloud.account.api.vo.AccountDataScopeVO;

import java.util.List;

/**
 * 数据范围服务.
 * Class created on 2024/4/8 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface IAccountDataScopeService {

    /**
     * 根据用户id获取数据范围.
     *
     * @param userId 用户id
     * @return 数据范围
     */
    List<AccountDataScopeVO> listAccountDataScopeByUserId(Long userId);
}
