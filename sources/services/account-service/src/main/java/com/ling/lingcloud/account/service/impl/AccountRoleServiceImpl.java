package com.ling.lingcloud.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.ling.lingcloud.account.api.convert.AccountRoleConvert;
import com.ling.lingcloud.account.api.dto.AccountRoleDTO;
import com.ling.lingcloud.account.api.entity.AccountRole;
import com.ling.lingcloud.account.api.vo.AccountRoleVO;
import com.ling.lingcloud.account.mapper.AccountRoleMapper;
import com.ling.lingcloud.account.service.IAccountRoleService;
import com.ling.lingcloud.common.mp.domain.PageQuery;
import com.ling.lingcloud.common.mp.domain.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 角色功能服务实现.
 * Class created on 2024/3/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Service
@RequiredArgsConstructor
public class AccountRoleServiceImpl implements IAccountRoleService {


    private final AccountRoleMapper accountRoleMapper;

    @Override
    public Boolean checkRoleKeyUnique(AccountRole role) {
        AccountRoleVO accountRoleByKey = getAccountRoleByKey(role.getRoleKey());
        return accountRoleByKey == null || Objects.equals(accountRoleByKey.getId(), role.getId());
    }

    @Override
    public Boolean stateChanges(Long id, Byte state) {
        return accountRoleMapper.setState(id, state);
    }

    @Override
    public PageResult<AccountRoleVO> listPageAccountRole(AccountRoleDTO roleDTO, PageQuery pageQuery) {
        QueryWrapper<AccountRole> queryWrapper = new QueryWrapper<>(AccountRoleConvert.INSTANCE.dtoToEntity(roleDTO));
        Page<AccountRole> page = accountRoleMapper.selectPage(pageQuery.build(), queryWrapper);
        return new PageResult<>(page.getTotal(), AccountRoleConvert.INSTANCE.convertToVOList(page.getRecords()));
    }

    @Override
    public Boolean saveAccountRole(AccountRoleDTO role) {
        return accountRoleMapper.insert(AccountRoleConvert.INSTANCE.dtoToEntity(role)) > 0;
    }

    @Override
    public Boolean updateAccountRole(AccountRoleDTO role) {
        return accountRoleMapper.updateById(AccountRoleConvert.INSTANCE.dtoToEntity(role)) > 0;
    }

    @Override
    public Boolean removeAccountRoleById(Long id) {
        return accountRoleMapper.deleteById(id) > 0;
    }

    @Override
    public AccountRoleVO getAccountRoleById(Long id) {
        return AccountRoleConvert.INSTANCE.convertToVO(accountRoleMapper.selectById(id));
    }

    @Override
    public AccountRoleVO getAccountRoleByKey(String key) {
        return AccountRoleConvert.INSTANCE.convertToVO(accountRoleMapper.getAccountRoleByKey(key));
    }

    @Override
    public Boolean removeAccountRoleByIds(List<Long> ids) {
        return accountRoleMapper.deleteBatchIds(ids) == ids.size();
    }

    @Override
    public Boolean saveAccountRoleList(List<AccountRoleDTO> roleList) {
        return Db.saveBatch(AccountRoleConvert.INSTANCE.dtoListToEntityList(roleList));
    }
}
