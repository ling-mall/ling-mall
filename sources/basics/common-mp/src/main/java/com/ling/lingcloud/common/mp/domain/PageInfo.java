package com.ling.lingcloud.common.mp.domain;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpStatus;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 分页信息类.
 *
 * @author 钟舒艺
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -4828260563069859319L;

    /**
     * 总记录数.
     */
    private long total;

    /**
     * 列表数据.
     */
    private transient List<T> items;

    /**
     * 状态码.
     */
    private int code;

    /**
     * 提示信息.
     */
    private String message;

    /**
     * response timestamp.
     */
    private long timestamp;

    /**
     * 类型.
     */
    private Boolean isSuccess;

    public static <T> PageInfo<T> build(IPage<T> page) {
        PageInfo<T> rspData = new PageInfo<>();
        rspData.setCode(HttpStatus.HTTP_OK);
        rspData.setMessage("查询成功");
        rspData.setItems(page.getRecords());
        rspData.setTotal(page.getTotal());
        rspData.setTimestamp(DateUtil.current());
        return rspData;
    }

}
