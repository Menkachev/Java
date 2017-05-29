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
       
       SELECT * FROM people;
       
       TRUNCATE TABLE users;
       
       DROP TABLE users;
       
       USE minions;
       
       DROP TABLE users;
       
       CREATE TABLE users
       (
         id INT AUTO_INCREMENT,
         username VARCHAR(30) NOT NULL,
         password VARCHAR(26) NOT NULL,
         profile_picture BLOB,
         last_login_time TIME,
         is_deleted BOOL,
         CONSTRAINT pk_users PRIMARY KEY (id)
       );
       
       INSERT INTO users (username, password, profile_picture, last_login_time, is_deleted)
       VALUES ('SmackThat', 'picha89', NULL, '19:03:00', FALSE),
              ('fenomena', 'fenNaLevski', NULL, '19:03:00', TRUE),
              ('PrisonBreak', 'michael98', NULL, '19:03:00', FALSE),
              ('sto4ko', 'sto4ko78', NULL, '19:03:00', FALSE),
              ('ro6aviq', 'gogetit', NULL, '19:03:00', FALSE);
              
	  
      ALTER TABLE users
      DROP PRIMARY KEY,
      ADD CONSTRAINT pk_users PRIMARY KEY (`id`, `username`);
      
      
      ALTER TABLE users
      DROP PRIMARY KEY,
      ADD CONSTRAINT pk_users PRIMARY KEY (id);
      
      ALTER TABLE users
      CHANGE username username VARCHAR(30) UNIQUE;
      
     
      
      