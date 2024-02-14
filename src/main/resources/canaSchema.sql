DROP table `buyer` CASCADE;
DROP table `seller` CASCADE;

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

