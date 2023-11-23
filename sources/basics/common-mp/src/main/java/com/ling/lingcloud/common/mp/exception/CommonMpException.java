package com.ling.lingcloud.common.mp.exception;

import com.ling.lingcloud.common.exception.BaseException;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 公共 mybatis plus 自定义的异常.
 * Class created on 2023/10/17 by 钟舒艺
 *
 * @author 钟舒艺
 */
@NoArgsConstructor
public class CommonMpException extends BaseException {
    public CommonMpException(String code, Serializable... args) {
        super("common-mp", code, args, null);
    }
}
