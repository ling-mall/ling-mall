package com.ling.lingcloud.account.service.impl;

import com.ling.lingcloud.account.api.convert.AccountAuthorityConvert;
import com.ling.lingcloud.account.api.convert.AccountRoleConvert;
import com.ling.lingcloud.account.api.vo.AccountAuthorityVO;
import com.ling.lingcloud.account.api.vo.AccountRoleVO;
import com.ling.lingcloud.account.mapper.PermissionMapper;
import com.ling.lingcloud.account.service.IPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限服务.
 * Class created on 2024/3/25 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Service
@RequiredArgsConstructor
public class IPermissionServiceImpl implements IPermissionService {

    private final PermissionMapper permissionMapper;

    @Override
    public List<AccountRoleVO> listUserRole(Long userId) {
        return AccountRoleConvert.INSTANCE.convertToVOList(permissionMapper.listUserRole(userId));
    }

    @Override
    public List<AccountRoleVO> listUserActualRole(Long userId) {
        return null;
    }

    @Override
    public Boolean setUserRole(Long userId, List<Long> roleIds) {
        return permissionMapper.setUserRoles(userId, roleIds) == roleIds.size();
    }

    @Override
    public List<AccountRoleVO> listUserGroupRole(Long userGroupId) {
        return AccountRoleConvert.INSTANCE.convertToVOList(permissionMapper.listUserGroupRole(userGroupId));
    }

    @Override
    public Boolean setUserGroupRole(Long userGroupId, List<Long> roleIds) {
        return permissionMapper.setUserGroupRoles(userGroupId, roleIds) == roleIds.size();
    }

    @Override
    public List<AccountAuthorityVO> listUserAllowAuthority(Long userId) {
        return null;
    }

    @Override
    public List<AccountAuthorityVO> listUserDisableAuthority(Long userId) {
        return AccountAuthorityConvert.INSTANCE.convertToVOList(permissionMapper.listUserAllowAuthority(userId));
    }

    @Override
    public Boolean setRoleAuthority(Long roleId, List<Long> authorityIdList) {
        return permissionMapper.setRoleAuthorities(roleId, authorityIdList) == authorityIdList.size();
    }

    @Override
    public List<AccountAuthorityVO> listRoleAuthority(Long roleId) {
        return AccountAuthorityConvert.INSTANCE.convertToVOList(permissionMapper.listRoleAuthority(roleId));
    }

    @Override
    public Boolean setUserAuthority(Long userId, Integer type, List<Long> authorityIdList) {
        return permissionMapper.setUserAuthorities(userId, type, authorityIdList) == authorityIdList.size();
    }

    @Override
    public List<AccountRoleVO> listDeptRole(Long departmentId) {
        return AccountRoleConvert.INSTANCE.convertToVOList(permissionMapper.listDeptRole(departmentId));
    }

    @Override
    public Boolean setDeptRole(Long departmentId, List<Long> roleIds) {
        return permissionMapper.setDeptRoles(departmentId, roleIds) == roleIds.size();
    }
}
