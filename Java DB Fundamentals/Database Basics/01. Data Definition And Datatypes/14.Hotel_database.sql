CREATE DATABASE hotel;
USE hotel;

CREATE TABLE employees
(
  id INT AUTO_INCREMENT NOT NULL,
  first_name VARCHAR(15) NOT NULL,
  last_name VARCHAR(15) NOT NULL,
  title VARCHAR(50),
  notes TEXT,
  CONSTRAINT pk_employees PRIMARY KEY (id)
);

INSERT INTO employees VALUES (1, 'Georgi', 'Ivanov', 'Piccolo', ''),
                             (2, 'Grogor', 'eorgiev', 'Receptionist', ''),
                             (3, 'Todor', 'Simeonov', 'Manager', '');
                             
                             
CREATE TABLE customers
(
  account_number INT AUTO_INCREMENT NOT NULL,
  first_name VARCHAR(15) NOT NULL,
  last_name VARCHAR(15) NOT NULL,
  phone_number INT,
  emergency_name VARCHAR(20),
  emergency_number INT,
  notes TEXT,
  CONSTRAINT pk_customers PRIMARY KEY (account_number)
);

INSERT INTO customers VALUES (123, 'Genadi', 'Nikolaev', 0895632145, 'Pantera', 0896325874, ''),
                             (234, 'Emanuil', 'Borisov', 0889542132, 'White Horse', 0895745632, ''),
                             (345, 'Vladimir', 'Shagov', 0899748596, 'Lyon', 0894741236, '');
                             
                             
CREATE TABLE room_status
(
  id INT AUTO_INCREMENT NOT NULL,
  room_status ENUM('free', 'busy') NOT NULL,
  notes TEXT,
  CONSTRAINT pk_room_status PRIMARY KEY (id)
);

INSERT INTO room_status VALUES (1, 'free', ''),
                               (2, 'busy', ''),
                               (3, 'free', '');
                               
                               
CREATE TABLE room_types
(
  id INT AUTO_INCREMENT NOT NULL,
  room_type ENUM('For Two', 'For Three', 'For Four', 'Apartment') NOT NULL,
  notes TEXT,
  CONSTRAINT pk_room_types PRIMARY KEY (id)
);

INSERT INTO room_types VALUES (1, 'Apartment', ''),
							  (2, 'For Two', ''),
							  (3, 'For Three', '');
                              
                              
CREATE TABLE bed_types
(
  id INT AUTO_INCREMENT NOT NULL,
  bed_type ENUM('single', 'couple') NOT NULL,
  notes TEXT,
  CONSTRAINT pk_room_status PRIMARY KEY (id)
);

INSERT INTO bed_types VALUES (1, 'single', ''),
							(2, 'couple', ''),
							(3, 'single', '');
                            
                            
CREATE TABLE rooms
(
  room_number INT NOT NULL,
  room_type ENUM('For Two', 'For Three', 'For Four', 'Apartment') NOT NULL,
  bed_type ENUM('single', 'couple') NOT NULL,
  rate DOUBLE(5, 2),
  room_status ENUM('free', 'busy') NOT NULL,
  notes TEXT,
  CONSTRAINT pk_rooms PRIMARY KEY (room_number)
);

INSERT INTO rooms VALUES (1, 'For Four', 'couple', 38, 'free', ''),
                         (2, 'Apartment', 'couple', 50, 'free', ''),
                         (3, 'For Two', 'single', 25, 'busy', '');
                         
                         
CREATE TABLE payments
(
  id INT AUTO_INCREMENT NOT NULL,
  employee_id INT NOT NULL,
  payment_date DATE,
  account_number INT,
  first_date_occupied DATE,
  last_date_occupied DATE,
  total_days INT,
  amount_charged DOUBLE(7, 2),
  tax_rate DOUBLE(7, 2),
  tax_amount DOUBLE(7, 2),
  payment_total DOUBLE(7, 2),
  notes TEXT,
  CONSTRAINT pk_payments PRIMARY KEY (id)
);

INSERT INTO payments VALUES (1, 3, '2017-06-12', 0000152360087, '2017-07-14', '2017-07-24', 10, 800, 100, 25.26, 825.26, ''),
                            (2, 1, '2017-01-12', 0000152360087, '2017-02-14', '2017-02-24', 10, 800, 100, 25.26, 825.26, ''),
                            (3, 2, '2017-03-12', 0000152360087, '2017-05-14', '2017-05-24', 10, 800, 100, 25.26, 825.26, '');
                            
                            
CREATE TABLE occupancies
(
  id INT AUTO_INCREMENT NOT NULL,
  employee_id INT NOT NULL,
  date_occupied DATE,
  account_number INT,
  room_number INT,
  rate_applied DOUBLE(7, 2),
  phone_charge DOUBLE(7, 2),
  notes TEXT,
  CONSTRAINT pk_occupancies PRIMARY KEY (id)
);

INSERT INTO occupancies VALUES (1, 2, '2017-08-12', 000045870011, 25, 80, 0, ''),
                               (2, 3, '2017-05-12', 000045870011, 25, 80, 0, ''),
                               (3, 1, '2017-10-12', 000045870011, 25, 80, 0, '');
                               
                               


UPDATE payments
SET payments.tax_rate=tax_rate - (tax_rate * 0.03);
SELECT tax_rate FROM payments;