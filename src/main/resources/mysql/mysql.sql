DROP TABLE IF EXISTS `wl_user`;
CREATE TABLE `wl_user`(
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` VARCHAR(100) NOT NULL COMMENT '用户id',
  `username` VARCHAR(20) NOT NULL COMMENT '用户名/昵称',
  `password` VARCHAR(20) NOT NULL COMMENT '用户密码',
  `email` VARCHAR(50) NOT NULL COMMENT '用户邮箱',
  `age` INT(11) COMMENT '年龄',
  `sex` VARCHAR(10) COMMENT '性别',
  `height` VARCHAR(10) COMMENT '身高',
  `weight` VARCHAR(10) COMMENT '体重',
  `address` VARCHAR(100) COMMENT '地址',
  `phone` VARCHAR(20) COMMENT '用户联系方式',
  `createTime` VARCHAR(50) COMMENT '创建时间',
  `updateTime` VARCHAR(50) COMMENT '修改时间/只记录最近一次修改时间',
  primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO `WL`.`wl_user` (`user_id`,`username`,`password`,`email`,`createTime`)VALUES ('11111','张三','19961127','Williamyg1996@gmail.com',NOW()) ;





