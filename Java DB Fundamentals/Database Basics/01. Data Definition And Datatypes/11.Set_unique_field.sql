ALTER TABLE users
      DROP PRIMARY KEY,
      ADD CONSTRAINT pk_users PRIMARY KEY (id);
      
      ALTER TABLE users
      CHANGE username username VARCHAR(30) UNIQUE;