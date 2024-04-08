package com.ling.lingcloud.account.api.convert;

import com.ling.lingcloud.account.api.dto.AccountGroupDTO;
import com.ling.lingcloud.account.api.vo.AccountGroupVO;
import com.ling.lingcloud.account.api.entity.AccountGroup;
import com.ling.lingcloud.common.interfaces.BaseConvert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 系统用户转换类.
 * Class created on 2024/3/18 by 钟舒艺
 *
 * @author 钟舒艺
 **/
@Mapper
public interface AccountGroupConvert extends BaseConvert<AccountGroupVO, AccountGroupDTO, AccountGroup> {

    /**
     * 实例.
     */
    AccountGroupConvert INSTANCE = Mappers.getMapper(AccountGroupConvert.class);
}
