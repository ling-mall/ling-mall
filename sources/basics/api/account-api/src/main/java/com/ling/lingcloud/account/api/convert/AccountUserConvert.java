package com.ling.lingcloud.account.api.convert;

import com.ling.lingcloud.account.api.dto.AccountUserDTO;
import com.ling.lingcloud.account.api.entity.AccountUser;
import com.ling.lingcloud.account.api.vo.AccountUserVO;
import com.ling.lingcloud.common.interfaces.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户转换类.
 * Class created on 2024/3/18 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Mapper
public interface AccountUserConvert extends BaseConvert<AccountUserVO, AccountUserDTO, AccountUser> {

    /**
     * 实例.
     */
    AccountUserConvert INSTANCE = Mappers.getMapper(AccountUserConvert.class);

}
