package com.ling.lingcloud.common.mp.domain;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.StrSplitter;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ling.lingcloud.common.exception.BusinessException;
import com.ling.lingcloud.common.mp.constants.MpConstants;
import com.ling.lingcloud.common.mp.exception.CommonMpErrorCodeEnum;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页查询条件.
 * 详细说说
 * Class created on 2023/10/17 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Data
public class PageQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 仅支持字母、数字、下划线.
     */
    public static final String SQL_PATTERN = "[a-zA-Z0-9_]+";

    /**
     * 多个 order 的分隔符.
     */
    public static final String ORDER_BY_DELIMITER = ",";

    /**
     * order 的连接符.
     */
    public static final String ORDER_BY_CONNECT = ":";

    /**
     * 升序 字符，前端传递
     */
    public static final String[] ASC_STRINGS = {"ascending", "asc"};

    /**
     * 降序叙 字符，前端传递
     */
    public static final String[] DESC_STRINGS = {"descending", "desc"};

    /**
     * 默认排序方式
     */
    public static final String DEFAULT_SORTING_METHOD = "asc";

    /**
     * 分页大小
     */
    private Long pageSize;

    /**
     * 当前页数
     */
    private Long pageNum;


    /**
     * 排序参数
     */
    private String orderBy;


    /**
     * 构建分页查询条件
     *
     * @param <T> 实体类
     * @return 查询对象
     */
    public <T> Page<T> build() {
        Long pageNum = ObjectUtil.defaultIfNull(getPageNum(), MpConstants.DEFAULT_PAGE_NUM);
        Long pageSize = ObjectUtil.defaultIfNull(getPageSize(), MpConstants.DEFAULT_PAGE_SIZE);
        if (pageNum <= 0) {
            pageNum = MpConstants.DEFAULT_PAGE_NUM;
        }
        Page<T> page = new Page<>(pageNum, pageSize);
        List<OrderItem> orderItems = buildOrderItem();
        if (CollUtil.isNotEmpty(orderItems)) {
            page.addOrder(orderItems);
        }
        return page;
    }

    /**
     * 根据 orderBy 构建排序条件.
     * 例子： age:asc,time:desc
     * age 字段 升序，time 字段 降序
     *
     * @return 排序条件
     */
    private List<OrderItem> buildOrderItem() {
        if (StrUtil.isBlank(getOrderBy())) {
            return new ArrayList<>();
        }

        List<String> orderStrBylist = StrSplitter.split(getOrderBy(), PageQuery.ORDER_BY_DELIMITER, 0, true, true);

        List<OrderItem> orderItemList = new ArrayList<>();

        if (CollUtil.isEmpty(orderStrBylist)) {
            return orderItemList;
        }

        orderStrBylist.forEach(orderByStr -> {
            // 将 a:desc 这种格式 分割
            String[] split = orderByStr.split(PageQuery.ORDER_BY_CONNECT);
            // 排序列名
            String columnName = split[0];
            // 检查是否符合规范
            if (!ReUtil.isMatch(PageQuery.SQL_PATTERN, columnName)) {
                throw new BusinessException(CommonMpErrorCodeEnum.ORDER_PARAMETER_ERROR, columnName);
            }
            // 排序方向
            String collation = PageQuery.DEFAULT_SORTING_METHOD;
            if (split.length == 2) {
                collation = split[1];
            }

            if (ArrayUtil.contains(ASC_STRINGS, collation)) {
                orderItemList.add(OrderItem.asc(columnName));
            }

            if (ArrayUtil.contains(DESC_STRINGS, collation)) {
                orderItemList.add(OrderItem.desc(columnName));
            }
        });
        return orderItemList;
    }
}
