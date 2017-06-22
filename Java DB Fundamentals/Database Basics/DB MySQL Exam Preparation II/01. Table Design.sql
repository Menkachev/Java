CREATE DATABASE `the_nerd_herd`;

CREATE TABLE `credentials` (
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY,
    `email` VARCHAR(30) NOT NULL,
    `password` VARCHAR(20) NOT NULL
);

CREATE TABLE `locations` (
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY,
    `latitude` FLOAT NOT NULL,
    `longitude` FLOAT NOT NULL
);

CREATE TABLE `users` (
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY,
    `nickname` VARCHAR(25) NOT NULL,
    `gender` CHAR(1) NOT NULL,
    `age` INT(11),
    `location_id` INT(11),
    `credential_id` INT(11) UNIQUE,
    CONSTRAINT `fk_location_id` FOREIGN KEY (`location_id`)
        REFERENCES `locations` (`id`),
    CONSTRAINT `fk_credential_id` FOREIGN KEY (`credential_id`)
        REFERENCES `credentials` (`id`)
);

CREATE TABLE `chats` (
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(32) NOT NULL,
    `start_date` DATE NOT NULL,
    `is_active` BIT(1) NOT NULL
);

CREATE TABLE `messages` (
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY,
    `content` VARCHAR(200) NOT NULL,
    `sent_on` DATE NOT NULL,
    `chat_id` INT(11),
    `user_id` INT(11),
    CONSTRAINT `fk_chat_id` FOREIGN KEY (`chat_id`)
        REFERENCES `chats` (`id`),
    CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `users` (`id`)
);

CREATE TABLE `users_chats` (
    `user_id` INT(11),
    `chat_id` INT(11),
    CONSTRAINT `pk_user_id_users` PRIMARY KEY (`user_id` , `chat_id`),
    CONSTRAINT `fk_user_id_users` FOREIGN KEY (`user_id`)
        REFERENCES `users` (`id`),
    CONSTRAINT `fk_chat_id_users` FOREIGN KEY (`chat_id`)
        REFERENCES `chats` (`id`)
);