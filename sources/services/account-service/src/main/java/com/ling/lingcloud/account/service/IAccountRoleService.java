package com.ling.lingcloud.account.service;

import com.ling.lingcloud.account.api.dto.AccountRoleDTO;
import com.ling.lingcloud.account.api.entity.AccountRole;
import com.ling.lingcloud.account.api.vo.AccountRoleVO;
import com.ling.lingcloud.common.mp.domain.PageQuery;
import com.ling.lingcloud.common.mp.domain.PageResult;

import java.util.List;

/**
 * 角色服务.
 * Class created on 2024/3/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface IAccountRoleService {

    /**
     * 检查角色的标识是否唯一.
     *
     * @param role 角色Bo
     */
    Boolean checkRoleKeyUnique(AccountRole role);

    /**
     * 更改角色状态.
     *
     * @param id    角色id
     * @param state 状态
     * @return 是否成功
     */
    Boolean stateChanges(Long id, Byte state);

    /**
     * 分页查询角色.
     *
     * @param roleDTO   角色Bo
     * @param pageQuery 分页查询参数
     * @return 分页结果
     */
    PageResult<AccountRoleVO> listPageAccountRole(AccountRoleDTO roleDTO, PageQuery pageQuery);

    /**
     * 保存角色.
     *
     * @param role 角色Bo
     * @return 是否成功
     */
    Boolean saveAccountRole(AccountRoleDTO role);

    /**
     * 更新角色.
     *
     * @param role 角色Bo
     * @return 是否成功
     */
    Boolean updateAccountRole(AccountRoleDTO role);


    /**
     * 删除角色.
     *
     * @param id 角色id
     * @return 是否成功
     */
    Boolean removeAccountRoleById(Long id);

    /**
     * 根据角色id查询角色.
     *
     * @param id 角色id
     * @return 角色Bo
     */
    AccountRoleVO getAccountRoleById(Long id);

    /**
     * 根据角色标识查询角色.
     *
     * @param key 角色标识
     * @return 角色Bo
     */
    AccountRoleVO getAccountRoleByKey(String key);

    /**
     * 批量删除角色.
     *
     * @param ids 角色id集合
     * @return 是否成功
     */
    Boolean removeAccountRoleByIds(List<Long> ids);

    /**
     * 批量保存角色.
     *
     * @param roleList 角色Bo集合
     * @return 是否成功
     */
    Boolean saveAccountRoleList(List<AccountRoleDTO> roleList);
}
