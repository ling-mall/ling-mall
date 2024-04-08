package com.ling.lingcloud.account.service.impl;

import com.ling.lingcloud.account.api.vo.AccountAuthorityVO;
import com.ling.lingcloud.account.api.vo.AccountRoleVO;
import com.ling.lingcloud.account.service.IPermissionService;

import java.util.List;

/**
 * 简短描述啦.
 * 详细说说
 * Class created on 2024/3/25 by 钟舒艺
 *
 * @author 钟舒艺
 */
public class IPermissionServiceImpl implements IPermissionService {
    @Override
    public List<AccountRoleVO> listUserRole(Long userId) {
        return null;
    }

    @Override
    public List<AccountRoleVO> listUserActualRole(Long userId) {
        return null;
    }

    @Override
    public Boolean setUserRole(Long userId, List<Long> roleIds) {
        return null;
    }

    @Override
    public List<AccountRoleVO> listUserGroupRole(Long userGroupId) {
        return null;
    }

    @Override
    public Boolean setUserGroupRole(Long userGroupId, List<Long> roleIds) {
        return null;
    }

    @Override
    public List<AccountAuthorityVO> listUserAllowAuthority(Long userId) {
        return null;
    }

    @Override
    public List<AccountAuthorityVO> listUserDisableAuthority(Long userId) {
        return null;
    }

    @Override
    public Boolean setRoleAuthority(Long roleId, List<Long> authorityIdList) {
        return null;
    }

    @Override
    public List<AccountAuthorityVO> listRoleAuthority(Long roleId) {
        return null;
    }

    @Override
    public Boolean setUserAuthority(Long userId, Integer type, List<Long> authorityIdList) {
        return null;
    }

    @Override
    public List<AccountRoleVO> listDeptRole(Long departmentId) {
        return null;
    }

    @Override
    public Boolean setDeptRole(Long departmentId, List<Long> roleIds) {
        return null;
    }
}
