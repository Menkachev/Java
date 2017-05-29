USE minions;

CREATE TABLE people
(
  id INT AUTO_INCREMENT,
  name VARCHAR(200) NOT NULL,
  picture MEDIUMBLOB,
  height FLOAT(5, 2),
  weight FLOAT(5, 2),
  gender ENUM('m', 'f') NOT NULL,
  birthdate DATE NOT NULL,
  biography TEXT,
  CONSTRAINT pk_people PRIMARY KEY (id)
);

INSERT INTO people (name, picture, height, weight, gender, birthdate, biography)
VALUES ('Ivan', NULL, 172.25, 70.54, 'm', '1987-07-29', ''),
       ('Georgi', NULL, 180, 82.54, 'm', '1987-06-11', ''),
       ('Snezhana', NULL, 162.25, 70.54, 'f', '1987-02-22', ''),
       ('Stefan', NULL, 190.45, 87.54, 'm', '1987-04-29', ''),
       ('Yordan', NULL, 186.25, 80.54, 'm', '1988-02-07', '');