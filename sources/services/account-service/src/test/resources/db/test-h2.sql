CREATE TABLE account_user
(
    id               bigint AUTO_INCREMENT PRIMARY KEY COMMENT '用户id',
    username         varchar(30)  NOT NULL COMMENT '用户账号',
    email            varchar(50)  NOT NULL DEFAULT '' COMMENT '用户邮箱',
    tel              varchar(15)  NOT NULL DEFAULT '' COMMENT '手机号码',
    password         varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
    status           tinyint      NOT NULL DEFAULT '1' COMMENT '帐号状态（1正常 0停用）',
    create_ip_at     varchar(12)  NOT NULL DEFAULT '' COMMENT '创建ip',
    last_login_at    bigint       NOT NULL DEFAULT '0' COMMENT '最后一次登录时间',
    last_login_ip_at varchar(12)  NOT NULL DEFAULT '' COMMENT '最后一次登录ip',
    login_count      int          NOT NULL DEFAULT '0' COMMENT '登录次数',
    remark           varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
    create_by        bigint       NOT NULL DEFAULT '0' COMMENT '创建者',
    create_time      timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by        bigint       NOT NULL DEFAULT '0' COMMENT '更新者',
    update_time      timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    is_deleted       tinyint      NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）'
);

INSERT INTO account_user (id, username, email, tel, password, status, create_ip_at, last_login_at, last_login_ip_at, login_count, remark, create_by, create_time, update_by, update_time, is_deleted) VALUES (1, 'admin', 'admin@qq.com', '17607952136', '$2a$10$KMjutg4g1Rx2CW1WNC0W/.zdGkXDhSGy939Ne3gzO4mToziqxDVA6', 1, '', 0, '', 0, '', 0, '2023-08-19 18:51:18', 0, '2023-08-19 18:55:44', 0);

