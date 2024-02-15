DROP table `buyer` CASCADE;
DROP table `seller` CASCADE;
DROP table `property` CASCADE;

CREATE TABLE `buyer` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR,
`last_name` VARCHAR,
`phone_num` VARCHAR,
`email_add` VARCHAR,
`post_code` VARCHAR
);

CREATE TABLE `seller` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR,
`last_name` VARCHAR,
`phone_num` VARCHAR,
`email_add` VARCHAR,
`post_code` VARCHAR
);

CREATE TABLE `property` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`seller_id` INT,
`bath` VARCHAR,
`beds` VARCHAR,
`grdn` VARCHAR,
`loc` VARCHAR,
`pcod` VARCHAR,
`prc` VARCHAR,
`status` VARCHAR,
FOREIGN KEY (`seller_id`) REFERENCES `seller` (`id`)
);

