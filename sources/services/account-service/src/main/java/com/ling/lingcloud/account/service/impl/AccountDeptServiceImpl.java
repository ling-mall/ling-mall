package com.ling.lingcloud.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ling.lingcloud.account.api.convert.AccountDeptConvert;
import com.ling.lingcloud.account.api.dto.AccountDeptDTO;
import com.ling.lingcloud.account.api.entity.AccountDept;
import com.ling.lingcloud.account.api.vo.AccountDeptVO;
import com.ling.lingcloud.account.mapper.AccountDeptMapper;
import com.ling.lingcloud.account.service.IAccountDeptService;
import com.ling.lingcloud.common.mp.domain.PageQuery;
import com.ling.lingcloud.common.mp.domain.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门服务实现.
 * Class created on 2024/3/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Service
@RequiredArgsConstructor
public class AccountDeptServiceImpl implements IAccountDeptService {

    private final AccountDeptMapper accountDeptMapper;

    @Override
    public List<AccountDeptVO> getDeptList(AccountDeptDTO accountDeptDTO) {
        QueryWrapper<AccountDept> queryWrapper = new QueryWrapper<>(AccountDeptConvert.INSTANCE.dtoToEntity(accountDeptDTO));
        return AccountDeptConvert.INSTANCE.convertToVOList(accountDeptMapper.selectList(queryWrapper));
    }

    @Override
    public PageResult<AccountDeptVO> getDeptListByPage(AccountDeptDTO accountDeptDTO, PageQuery pageQuery) {
        QueryWrapper<AccountDept> queryWrapper = new QueryWrapper<>(AccountDeptConvert.INSTANCE.dtoToEntity(accountDeptDTO));
        Page<AccountDept> page = accountDeptMapper.selectPage(pageQuery.build(), queryWrapper);
        return new PageResult<>(page.getTotal(), AccountDeptConvert.INSTANCE.convertToVOList(page.getRecords()));
    }

    @Override
    public Boolean addDept(AccountDeptDTO accountDeptDTO) {
        AccountDept accountDept = AccountDeptConvert.INSTANCE.dtoToEntity(accountDeptDTO);
        boolean success = accountDeptMapper.insert(accountDept) > 0;
        accountDeptDTO.setId(accountDept.getId());
        return success;
    }

    @Override
    public Boolean deleteDeptById(Long id) {
        return accountDeptMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean updateDept(AccountDeptDTO accountDeptDTO) {
        return accountDeptMapper.updateById(AccountDeptConvert.INSTANCE.dtoToEntity(accountDeptDTO)) > 0;
    }

    @Override
    public AccountDeptDTO getDeptById(Long id) {
        return AccountDeptConvert.INSTANCE.convertToDTO(accountDeptMapper.selectById(id));
    }
}
