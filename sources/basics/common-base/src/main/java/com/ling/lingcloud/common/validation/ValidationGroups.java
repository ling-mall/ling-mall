package com.ling.lingcloud.common.validation;

/**
 * 分组校验类.
 *
 * @author 钟舒艺
 **/
@SuppressWarnings("unused")
public class ValidationGroups {

    /**
     * 添加时校验.
     */
    public interface Add {
    }

    /**
     * 编辑时校验.
     */
    public interface Edit {
    }

    /**
     * 查询时校验.
     */
    public interface Query {
    }

    /**
     * 添加时校验标识.
     */
    public static final Class<Add> ADD = Add.class;

    /**
     * 修改时校验标识.
     */
    public static final Class<Edit> EDIT = Edit.class;

    /**
     * 查询时校验标识.
     */
    public static final Class<Query> QUERY = Query.class;

}
