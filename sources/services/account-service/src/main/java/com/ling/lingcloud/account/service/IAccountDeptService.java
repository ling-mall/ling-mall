package com.ling.lingcloud.account.service;

import com.ling.lingcloud.account.api.dto.AccountDeptDTO;
import com.ling.lingcloud.account.api.vo.AccountDeptVO;
import com.ling.lingcloud.common.mp.domain.PageQuery;
import com.ling.lingcloud.common.mp.domain.PageResult;

import java.util.List;

/**
 * 部门服务.
 * Class created on 2024/3/12 by 钟舒艺
 *
 * @author 钟舒艺
 */
public interface IAccountDeptService {

    /**
     * 获取部门列表.
     *
     * @param accountDeptDTO 部门信息
     * @return 部门列表
     */
    List<AccountDeptVO> getDeptList(AccountDeptDTO accountDeptDTO);


    /**
     * 分页获取部门列表.
     *
     * @param accountDeptDTO 部门信息
     * @param pageQuery      分页信息
     * @return 部门列表
     */
    PageResult<AccountDeptVO> getDeptListByPage(AccountDeptDTO accountDeptDTO, PageQuery pageQuery);


    /**
     * 添加部门.
     *
     * @param accountDeptDTO 部门信息
     * @return 是否成功
     */
    Boolean addDept(AccountDeptDTO accountDeptDTO);

    /**
     * 删除部门.
     *
     * @param id 部门id
     * @return 是否成功
     */
    Boolean deleteDeptById(Long id);

    /**
     * 更新部门.
     *
     * @param accountDeptDTO 部门信息
     * @return 是否成功
     */
    Boolean updateDept(AccountDeptDTO accountDeptDTO);

    /**
     * 获取 部门 信息.
     *
     * @param id 部门id
     * @return 部门信息
     */
    AccountDeptDTO getDeptById(Long id);


}
