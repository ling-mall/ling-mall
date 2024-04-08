package com.ling.lingcloud.account.api.convert;

import com.ling.lingcloud.account.api.dto.AccountAuthorityDTO;
import com.ling.lingcloud.account.api.entity.AccountAuthority;
import com.ling.lingcloud.account.api.vo.AccountAuthorityVO;
import com.ling.lingcloud.common.interfaces.BaseConvert;
import org.mapstruct.factory.Mappers;

/**
 * 权限视图.
 * Class created on 2024/3/22 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface AccountAuthorityConvert extends BaseConvert<AccountAuthorityVO, AccountAuthorityDTO, AccountAuthority> {
    /**
     * 实例.
     */
    AccountAuthorityConvert INSTANCE = Mappers.getMapper(AccountAuthorityConvert.class);

}
