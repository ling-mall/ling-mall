package com.ling.lingcloud.account.service;

import com.ling.lingcloud.account.api.dto.AccountAuthorityDTO;

import java.util.List;

/**
 * 权限服务.
 * Class created on 2024/3/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface IAccountAuthorityService {

    /**
     * 通过id列表查询权限.
     *
     * @param ids 权限id
     * @return 权限信息
     */
    List<AccountAuthorityDTO> listAuthorityByIds(List<Long> ids);


    /**
     * 添加权限.
     *
     * @param accountAuthorityDTO 权限信息
     * @return 是否添加成功
     */
    Boolean addAuthority(AccountAuthorityDTO accountAuthorityDTO);

    /**
     * 删除权限.
     *
     * @param id 权限id
     * @return 是否删除成功
     */
    Boolean deleteAuthorityById(Long id);

    /**
     * 修改权限.
     *
     * @param accountAuthorityDTO 权限信息
     * @return 是否修改成功
     */
    Boolean updateAuthority(AccountAuthorityDTO accountAuthorityDTO);

    /**
     * 查询权限.
     *
     * @param id 权限id
     * @return 权限信息
     */
    AccountAuthorityDTO getAuthority(Long id);

    /**
     * 批量删除权限.
     *
     * @param ids 权限id
     * @return 是否删除成功
     */
    Boolean deleteAuthority(List<Long> ids);

    /**
     * 批量添加权限.
     *
     * @param accountAuthorityDTOList 权限信息
     * @return 是否添加成功
     */
    Boolean addAuthority(List<AccountAuthorityDTO> accountAuthorityDTOList);
}
