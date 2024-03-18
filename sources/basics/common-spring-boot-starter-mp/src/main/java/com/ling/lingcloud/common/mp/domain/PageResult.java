package com.ling.lingcloud.common.mp.domain;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpStatus;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ling.lingcloud.common.exception.CommonCodeEnum;
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
public class PageResult<T> implements Serializable {

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


    public static <T> PageResult<T> build(IPage<T> page) {
        PageResult<T> rspData = new PageResult<>();
        rspData.setItems(page.getRecords());
        rspData.setTotal(page.getTotal());
        return rspData;
    }

    public static <T> PageResult<T> build(List<T> list) {
        PageResult<T> rspData = new PageResult<>();
        rspData.setItems(list);
        rspData.setTotal(list.size());
        return rspData;
    }
}
