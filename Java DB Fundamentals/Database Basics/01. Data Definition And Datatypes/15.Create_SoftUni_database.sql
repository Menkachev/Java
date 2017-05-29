CREATE TABLE towns
(
  id INT AUTO_INCREMENT NOT NULL,
  name VARCHAR(50),
  CONSTRAINT pk_towns PRIMARY KEY (id)
  );
  
  CREATE TABLE addresses
  (  
    id INT AUTO_INCREMENT NOT NULL,
    address_text TEXT,
    town_id INT NOT NULL,
    CONSTRAINT pk_addresses PRIMARY KEY (id),
    CONSTRAINT fk_town_id FOREIGN KEY (town_id) REFERENCES towns (id)
  );
  
  CREATE TABLE departments
  (
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(30),
    CONSTRAINT pk_departments PRIMARY KEY (id)
  );
  
  CREATE TABLE employees
  (
    id INT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(20),
    middle_name VARCHAR(20),
    last_name VARCHAR(20),
    job_title VARCHAR(50),
    department_id INT,
    hire_date DATE,
    salary INT,
    address_id INT,
    CONSTRAINT pk_employees PRIMARY KEY (id),
    CONSTRAINT fk_department_id FOREIGN KEY (department_id) REFERENCES departments (id),
    CONSTRAINT fk_address_id FOREIGN KEY (address_id) REFERENCES addresses (id) 
  );