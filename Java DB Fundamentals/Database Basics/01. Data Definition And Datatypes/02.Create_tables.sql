CREATE TABLE minions
(
  id INT,
  name VARCHAR (25) NOT NULL,
  age INT,
  CONSTRAINT pk_minions PRIMARY KEY (id)
);
CREATE TABLE towns
(
  id INT,
  name VARCHAR (25) NOT NULL,
  CONSTRAINT pk_towns PRIMARY KEY (id)
);