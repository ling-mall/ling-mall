package com.ling.lingcloud.account.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.ling.lingcloud.account.api.convert.AccountAuthorityConvert;
import com.ling.lingcloud.account.api.dto.AccountAuthorityDTO;
import com.ling.lingcloud.account.api.entity.AccountAuthority;
import com.ling.lingcloud.account.api.vo.AccountAuthorityVO;
import com.ling.lingcloud.account.mapper.AccountAuthorityMapper;
import com.ling.lingcloud.account.service.IAccountAuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限服务实现类.
 * Class created on 2024/3/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Service
@RequiredArgsConstructor
public class AccountAuthorityServiceImpl implements IAccountAuthorityService {

    private final AccountAuthorityMapper accountAuthorityMapper;


    @Override
    public List<AccountAuthorityVO> listAuthorityByIds(List<Long> ids) {
        return AccountAuthorityConvert.INSTANCE.convertToVOList(accountAuthorityMapper.selectBatchIds(ids));
    }

    @Override
    public Boolean addAuthority(AccountAuthorityDTO accountAuthorityDTO) {
        AccountAuthority accountAuthority = AccountAuthorityConvert.INSTANCE.dtoToEntity(accountAuthorityDTO);
        return accountAuthorityMapper.insert(accountAuthority) > 0;
    }

    @Override
    public Boolean deleteAuthorityById(Long id) {
        return accountAuthorityMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateAuthority(AccountAuthorityDTO accountAuthorityDTO) {
        AccountAuthority accountAuthority = AccountAuthorityConvert.INSTANCE.dtoToEntity(accountAuthorityDTO);
        return accountAuthorityMapper.updateById(accountAuthority) > 0;
    }

    @Override
    public AccountAuthorityDTO getAuthority(Long id) {
        return AccountAuthorityConvert.INSTANCE.convertToDTO(accountAuthorityMapper.selectById(id));
    }

    @Override
    public Boolean deleteAuthority(List<Long> ids) {
        return accountAuthorityMapper.deleteBatchIds(ids) == ids.size();
    }

    @Override
    public Boolean addAuthority(List<AccountAuthorityDTO> accountAuthorityDTOList) {
        return Db.saveBatch(AccountAuthorityConvert.INSTANCE.dtoListToEntityList(accountAuthorityDTOList));
    }
}
