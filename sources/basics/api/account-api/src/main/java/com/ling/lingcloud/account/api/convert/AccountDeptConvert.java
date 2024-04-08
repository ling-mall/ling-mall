package com.ling.lingcloud.account.api.convert;

import com.ling.lingcloud.account.api.dto.AccountDeptDTO;
import com.ling.lingcloud.account.api.entity.AccountDept;
import com.ling.lingcloud.account.api.vo.AccountDeptVO;
import com.ling.lingcloud.common.interfaces.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 系统用户转换类.
 *
 * @author 钟舒艺
 * @since 2022-10-22 11:09
 **/
@Mapper
public interface AccountDeptConvert extends BaseConvert<AccountDeptVO, AccountDeptDTO, AccountDept> {

    /**
     * 实例.
     */
    AccountDeptConvert INSTANCE = Mappers.getMapper(AccountDeptConvert.class);
}
