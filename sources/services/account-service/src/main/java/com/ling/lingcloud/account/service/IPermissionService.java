package com.ling.lingcloud.account.service;

import com.ling.lingcloud.account.api.vo.AccountAuthorityVO;
import com.ling.lingcloud.account.api.vo.AccountRoleVO;

import java.util.List;

/**
 * 权限服务.
 * Class created on 2024/3/20 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface IPermissionService {

    /**
     * 获取用户角色.
     *
     * @param userId 用户id
     * @return 用户角色
     */
    List<AccountRoleVO> listUserRole(Long userId);

    /**
     * 设置用户角色.
     *
     * @param userId  用户id
     * @param roleIds 角色id 列表
     */
    Boolean setUserRole(Long userId, List<Long> roleIds);

    /**
     * 获取用户组角色.
     *
     * @param userId 用户id
     * @return 用户组角色
     */
    List<AccountRoleVO> listUserGroupRole(Long userId);


    /**
     * 设置用户组角色.
     *
     * @param userId 用户id
     * @param roleIds 角色id 列表
     */
    Boolean setUserGroupRole(Long userId, List<Long> roleIds);

    /**
     * 获取用户拥有的权限.
     *
     * @param userId 用户id
     * @return 用户权限
     */
    List<AccountAuthorityVO> listUserAuthority(Long userId);

    /**
     * 获取用户禁用权限.
     *
     * @param userId 用户id
     * @return 用户禁用权限
     */
    List<AccountAuthorityVO> listUserDisableAuthority(Long userId);

    /**
     * 设置角色权限.
     *
     * @param roleId          角色id
     * @param authorityIdList 权限id列表
     * @return 是否设置成功
     */
    Boolean setRoleAuthority(Long roleId, List<Long> authorityIdList);

    /**
     * 获取角色权限.
     *
     * @param roleId 角色id
     * @return 角色权限
     */
    List<AccountAuthorityVO> listRoleAuthority(Long roleId);

    /**
     * 设置用户权限.
     *
     * @param userId 用户id
     * @param authorityIdList 权限id列表
     * @return 是否设置成功
     */
    Boolean setUserAuthority(Long userId, List<Long> authorityIdList);
}
