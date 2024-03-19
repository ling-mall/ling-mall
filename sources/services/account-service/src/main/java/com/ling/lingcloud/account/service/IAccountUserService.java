package com.ling.lingcloud.account.service;


import com.ling.lingcloud.account.api.dto.AccountUserDTO;
import com.ling.lingcloud.account.api.entity.AccountUser;
import com.ling.lingcloud.account.api.vo.AccountUserVO;
import com.ling.lingcloud.common.mp.domain.PageResult;
import com.ling.lingcloud.common.mp.domain.PageQuery;

import java.util.List;

/**
 * 账户服务接口.
 *
 * @author 钟舒艺
 */
public interface IAccountUserService {

    /**
     * 根据用户名查询账号.
     *
     * @param username 用户名
     * @return 用户信息
     */
    AccountUser getUserByUserName(String username);


    /**
     * 根据用户ID查询账号.
     *
     * @param userId 用户ID
     * @return 用户信息
     */
    AccountUserVO getUserByUserId(Long userId);


    /**
     * 分页查询账号.
     *
     * @param accountUserDTO 查询条件
     * @param pageQuery      分页条件
     * @return 分页信息
     */
    PageResult<AccountUserVO> listPageAccountUser(AccountUserDTO accountUserDTO, PageQuery pageQuery);

    /**
     * 保存账号.
     *
     * @param accountUser 账号信息
     * @return 是否保存成功
     */
    Boolean saveAccountUser(AccountUserDTO accountUser);

    /**
     * 批量保存账号.
     *
     * @param accountUserList 账号信息列表
     * @return 是否保存成功
     */
    Boolean saveAccountUserList(List<AccountUserDTO> accountUserList);

    /**
     * 更新账号.
     *
     * @param accountUser 账号信息
     * @return 是否更新成功
     */
    Boolean updateAccountUser(AccountUserDTO accountUser);


    /**
     * 批量删除账号.
     *
     * @param ids 账号ID列表
     * @return 是否删除成功
     */
    Boolean removeAccountUserByIds(List<Long> ids);


    /**
     * 检查用户名是否重复.
     *
     * @param userDTO 用户信息
     * @return 是否重复
     */
    Boolean checkUsernameUnique(AccountUserDTO userDTO);
}
