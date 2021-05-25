DROP TABLE IF EXISTS `test_user`;
CREATE TABLE `test_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `create_at` int(10) NOT NULL COMMENT '创建时间',
  `update_at` int(10) NOT NULL COMMENT '更新时间',
  `delete_at` int(10) DEFAULT NULL COMMENT '删除时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

DROP TABLE IF EXISTS `test_role`;
CREATE TABLE `test_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(64) NOT NULL COMMENT '角色名',
  `memo` varchar(64) NOT NULL COMMENT '备注',
  `create_at` int(10) NOT NULL COMMENT '创建时间',
  `update_at` int(10) NOT NULL COMMENT '更新时间',
  `delete_at` int(10) DEFAULT NULL COMMENT '删除时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

DROP TABLE IF EXISTS `test_user_role`;
CREATE TABLE `test_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `create_at` int(10) NOT NULL COMMENT '创建时间',
  `update_at` int(10) NOT NULL COMMENT '更新时间',
  `delete_at` int(10) DEFAULT NULL COMMENT '删除时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

insert into test_user(username, password, create_at, update_at) values ('andy', '9ca283a788c02b1db7d2bdc6849ccc3b2cc14f28eb008a715150e6055d8a1967259faa3521916d4f', UNIX_TIMESTAMP(), UNIX_TIMESTAMP());
insert into test_user(username, password, create_at, update_at) values ('kitty', '9ca283a788c02b1db7d2bdc6849ccc3b2cc14f28eb008a715150e6055d8a1967259faa3521916d4f', UNIX_TIMESTAMP(), UNIX_TIMESTAMP());

insert into test_role(name, memo, create_at, update_at) values('ROLE_ADMIN', '管理员', UNIX_TIMESTAMP(), UNIX_TIMESTAMP());
insert into test_role(name, memo, create_at, update_at) values('ROLE_USER', '普通员', UNIX_TIMESTAMP(), UNIX_TIMESTAMP());

insert into test_user_role(user_id, role_id, create_at, update_at) values(1, 1, UNIX_TIMESTAMP(), UNIX_TIMESTAMP());
insert into test_user_role(user_id, role_id, create_at, update_at) values(2, 2, UNIX_TIMESTAMP(), UNIX_TIMESTAMP());
