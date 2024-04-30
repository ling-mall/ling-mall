package com.ling.lingcloud.account.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ling.lingcloud.account.api.convert.AccountUserConvert;
import com.ling.lingcloud.account.api.dto.AccountUserDTO;
import com.ling.lingcloud.account.api.entity.AccountUser;
import com.ling.lingcloud.account.api.vo.AccountUserVO;
import com.ling.lingcloud.account.mapper.AccountUserMapper;
import com.ling.lingcloud.account.service.IAccountUserService;
import com.ling.lingcloud.common.mp.domain.PageQuery;
import com.ling.lingcloud.common.mp.domain.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户服务.
 * Class created on 2023/7/8 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Service
@RequiredArgsConstructor
public class AccountUserServiceImpl implements IAccountUserService {

    private final AccountUserMapper accountUserMapper;

    @Override
    public AccountUser getUserByUserName(String username) {
        return accountUserMapper.selectUserByUserName(username);
    }

    @Override
    public AccountUserVO getUserByUserId(Long userId) {
        return AccountUserConvert.INSTANCE.convertToVO(accountUserMapper.selectById(userId));
    }

    @Override
    public PageResult<AccountUserVO> listPageAccountUser(AccountUserDTO accountUserDTO, PageQuery pageQuery) {
        QueryWrapper<AccountUser> queryWrapper = new QueryWrapper<>(AccountUserConvert.INSTANCE.dtoToEntity(accountUserDTO));
        Page<AccountUser> accountUserPage = accountUserMapper.selectPage(pageQuery.build(), queryWrapper);
        return new PageResult<>(accountUserPage.getTotal(), AccountUserConvert.INSTANCE.convertToVOList(accountUserPage.getRecords()));
    }

    @Override
    public List<AccountUserVO> listAccountUserByIds(List<Long> ids) {
        return AccountUserConvert.INSTANCE.convertToVOList(accountUserMapper.selectBatchIds(ids));
    }

    @Override
    public Boolean saveAccountUser(AccountUserDTO accountUser) {
        return accountUserMapper.insert(AccountUserConvert.INSTANCE.dtoToEntity(accountUser)) > 0;
    }

    @Override
    public Boolean saveAccountUserList(List<AccountUserDTO> accountUserList) {
        return accountUserMapper.insertAccountUserList(AccountUserConvert.INSTANCE.dtoListToEntityList(accountUserList));
    }

    @Override
    public Boolean updateAccountUser(AccountUserDTO accountUser) {
        return accountUserMapper.updateById(AccountUserConvert.INSTANCE.dtoToEntity(accountUser)) > 0;
    }

    @Override
    public Boolean removeAccountUserByIds(List<Long> ids) {
        return accountUserMapper.deleteBatchIds(ids) == ids.size();
    }

    @Override
    public Boolean checkUsernameUnique(AccountUserDTO userDTO) {
        final AccountUser user = getUserByUserName(userDTO.getUsername());
        if (userDTO.getId() != null) {
            return user != null && user.getId().equals(userDTO.getId());
        } else {
            return user == null;
        }
    }
}
