-- auto-generated definition
create table user
(
  id       int auto_increment
    primary key,
  account  varchar(64) null
  comment '账号',
  password varchar(64) null
  comment '密码',
  nickName varchar(64) null
  comment '昵称'
);

