create database user_management
drop database `user_management`;
use `user_management`;
create table users(
  `id` bigint not null auto_increment,
  `name` varchar(255) not null,
  `email` varchar(255) not null,
  `password` varchar(255) not null,
  primary key(`id`)
) engine = InnoDB AUTO_INCREMENT=1 charset=utf8mb4;

create table roles(
`id` bigint not null auto_increment,
`name` varchar(255) not null,
primary key(`id`)
) engine = InnoDB auto_increment=1 charset=utf8mb4;

create table users_roles(
`user_id` bigint not null,
`role_id` bigint not null,
 PRIMARY KEY (`user_id`,`role_id`),
  
  KEY `FK_USER_idx` (`user_id`),
  
  CONSTRAINT `FK_USER` FOREIGN KEY (`user_id`) 
  REFERENCES `users` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) 
  REFERENCES `roles` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
