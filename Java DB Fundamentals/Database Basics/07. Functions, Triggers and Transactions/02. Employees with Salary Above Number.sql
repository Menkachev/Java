DELIMITER $$
CREATE PROCEDURE
`usp_get_employees_salary_above`(IN `employee_salary` DECIMAL(19,4))
BEGIN
SELECT e.`first_name`, e.`last_name` 
FROM `employees` AS e 
WHERE e.`salary` >= `employee_salary` 
ORDER BY e.`first_name`, e.`last_name`;
END$$
DELIMITER ;

CALL `usp_get_employees_salary_above`(48100);