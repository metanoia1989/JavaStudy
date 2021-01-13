CREATE DATABASE `jdbc_template` DEFAULT CHARACTER SET utf8;
USE `jdbc_template`;

CREATE TABLE `book` (
    `id` int (11)NOT NULL AUTO_INCREMENT,
    `name` varchar (128) DEFAULT NULL,
    `author` varchar(64) DEFAULT NULL,
    PRIMARY KEY (`id`)
)
ENGINE=InnoDB 
DEFAULT CHARSET=utf8;

insert into `book` (`id`, `name`, `author`) values (1, '三国演义', '罗贯中'), (2, '水浒传', '施耐庵');