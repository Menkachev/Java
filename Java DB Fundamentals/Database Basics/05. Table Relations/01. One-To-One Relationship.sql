CREATE DATABASE `one_to_one_relationsfip`;

CREATE TABLE `passports` (
    `passport_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `passport_number` VARCHAR(50)
);

CREATE TABLE `persons` (
    `person_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(20),
    `salary` DECIMAL(10 , 2 ),
    `passport_id` INT UNIQUE,
    CONSTRAINT `fk_persons_passports` FOREIGN KEY (`passport_id`)
        REFERENCES `passports` (`passport_id`)
);

INSERT INTO `passports`(`passport_id`, `passport_number`) 
VALUES(101, 'N34FG21B'),
      (102, 'K65LO4R7'),
      (103, 'ZE657QP2');
      
INSERT INTO `persons`(`person_id`, `first_name`, `salary`, `passport_id`)
VALUES(1, 'Roberto', 43300, 102),
      (2, 'Tom', 56100, 103),
      (3, 'Yana', 60200, 101);
