package com.ling.lingcloud.account.mapper;

import com.ling.lingcloud.account.api.entity.AccountAuthority;
import com.ling.lingcloud.account.api.entity.AccountRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限操作映射.
 * Class created on 2024/3/26 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Repository
public interface PermissionMapper {

    /**
     * 获取用户角色.
     *
     * @param userId 用户id
     * @return 用户角色
     */
    List<AccountRole> listUserRole(Long userId);


    /**
     * 删除用户角色.
     *
     * @param userId  用户id
     * @param roleIds 角色id
     * @return 影响行数
     */
    int deleteUserRole(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);

    /**
     * 设置用户角色.
     *
     * @param userId  用户id
     * @param roleIds 角色id
     * @return 影响行数
     */
    int setUserRoles(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);

    /**
     * 获取用户组角色.
     *
     * @param userGroupId 用户组id
     * @return 用户组角色
     */
    List<AccountRole> listUserGroupRole(Long userGroupId);

    /**
     * 删除用户组角色.
     *
     * @param userGroupId 用户组id
     * @param roleIds     角色id
     * @return 影响行数
     */
    int deleteUserGroupRole(@Param("userGroupId") Long userGroupId, @Param("roleIds") List<Long> roleIds);

    /**
     * 设置用户组角色.
     *
     * @param userGroupId 用户组id
     * @param roleIds     角色id
     * @return 影响行数
     */
    int setUserGroupRoles(@Param("userGroupId") Long userGroupId, @Param("roleIds") List<Long> roleIds);

    /**
     * 获取角色权限.
     *
     * @param roleId 角色id
     * @return 角色权限
     */
    List<AccountAuthority> listRoleAuthority(Long roleId);

    /**
     * 删除角色权限.
     *
     * @param roleId          角色id
     * @param authorityIdList 权限id
     * @return 影响行数
     */
    int deleteRoleAuthorities(@Param("roleId") Long roleId, @Param("authorityIdList") List<Long> authorityIdList);

    /**
     * 设置角色权限.
     *
     * @param roleId          角色id
     * @param authorityIdList 权限id
     * @return 影响行数
     */
    int setRoleAuthorities(@Param("roleId") Long roleId, @Param("authorityIdList") List<Long> authorityIdList);


    /**
     * 获取用户权限 只包括允许的权限.
     *
     * @param userId 用户id
     * @return 用户权限
     */
    List<AccountAuthority> listUserAllowAuthority(Long userId);

    /**
     * 删除用户权限  只包括允许的权限.
     *
     * @param userId          用户id
     * @param authorityIdList 权限id
     * @return 影响行数
     */
    int deleteUserAuthorities(@Param("userId") Long userId, @Param("authorityIdList") List<Long> authorityIdList);


    /**
     * 获取用户权限 只包括禁止的权限
     *
     * @param userId 用户id
     * @return 用户权限
     */
    List<AccountAuthority> listUserDisableAuthority(Long userId);

    /**
     * 删除用户权限 只包括禁止的权限.
     *
     * @param userId          用户id
     * @param authorityIdList 权限id
     * @return 影响行数
     */
    int deleteUserDisableAuthorities(@Param("userId") Long userId, @Param("authorityIdList") List<Long> authorityIdList);

    /**
     * 设置用户权限.
     *
     * @param userId          用户id
     * @param type            权限类型 0 允许 1 禁止
     * @param authorityIdList 权限id
     * @return 影响行数
     */
    int setUserAuthorities(@Param("userId") Long userId, @Param("type") Integer type, @Param("authorityIdList") List<Long> authorityIdList);

    /**
     * 获取 部门 角色.
     *
     * @param deptId 部门id
     * @return 部门角色
     */
    List<AccountRole> listDeptRole(Long deptId);

    /**
     * 删除 部门 角色.
     *
     * @param deptId  部门id
     * @param roleIds 角色id
     * @return 影响行数
     */
    int deleteDeptRoles(@Param("deptId") Long deptId, @Param("roleIds") List<Long> roleIds);

    /**
     * 设置 部门 角色.
     *
     * @param deptId  部门id
     * @param roleIds 角色id
     * @return 影响行数
     */
    int setDeptRoles(@Param("deptId") Long deptId, @Param("roleIds") List<Long> roleIds);
}
