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