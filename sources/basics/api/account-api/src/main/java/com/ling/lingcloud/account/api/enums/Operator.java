package com.ling.lingcloud.account.api.enums;

import lombok.Getter;

/**
 * 运算符.
 * Class created on 2024/4/8 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Getter
public enum Operator {
    EQUAL("eq", "等于运算符"),
    NOT_EQUAL("ne", "不等于运算符"),
    GREATER_THAN("gt", "大于运算符"),
    GREATER_EQUAL("ge", "大于等于运算符"),
    LESS_THAN("lt", "小于运算符"),
    LESS_EQUAL("le", "小于等于运算符"),
    BETWEEN("bt", "在...之间（范围查询）运算符"),
    NOT_BETWEEN("nb", "不在...之间（范围查询）运算符"),
    CONTAIN("ct", "包含（模糊查询）运算符"),
    START_WITH("sw", "以...开头（模糊查询）运算符"),
    END_WITH("ew", "以...结尾（模糊查询）运算符"),
    OR_LIKE("ol", "模糊或匹配（可有多个参数值）运算符"),
    NOT_LIKE("nk", "反模糊匹配运算符"),
    IN_LIST("il", "多值查询运算符"),
    NOT_IN("ni", "不在多值查询中运算符"),
    IS_NULL("nl", "为空运算符"),
    NOT_NULL("nn", "不为空运算符"),
    EMPTY("ey", "为空（仅适用于 字符串 类型的字段）运算符"),
    NOT_EMPTY("ny", "不为空（仅适用于 字符串 类型的字段）运算符");

    /**
     * 运算符的代码。
     */
    private final String code;

    /**
     * 运算符的描述。
     */
    private final String description;

    Operator(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
