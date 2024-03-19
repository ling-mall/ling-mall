package com.ling.lingcloud.account.api.convert;

import com.ling.lingcloud.account.api.dto.AccountRoleDTO;
import com.ling.lingcloud.account.api.entity.AccountRole;
import com.ling.lingcloud.account.api.vo.AccountRoleVO;
import com.ling.lingcloud.common.interfaces.BaseConvert;
import org.mapstruct.factory.Mappers;

/**
 * 角色转换器.
 * Class created on 2024/3/19 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface AccountRoleConvert extends BaseConvert<AccountRoleVO, AccountRoleDTO, AccountRole> {
    /**
     * 实例.
     */
    AccountRoleConvert INSTANCE = Mappers.getMapper(AccountRoleConvert.class);

}
