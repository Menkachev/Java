DELIMITER $$
CREATE FUNCTION `ufn_get_salary_level`(`salary` DECIMAL(19,4))
RETURNS VARCHAR(15)
 BEGIN
    DECLARE `salary_level` VARCHAR(10);
  IF (`salary` < 30000) THEN 
  SET `salary_level` = 'Low';
  ELSEIF (`salary` >= 30000 AND `salary` <= 50000) THEN 
  SET `salary_level` = 'Average';
  ELSE 
  SET `salary_level` = 'High';
  END IF;
  RETURN `salary_level`;
 END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `usp_get_employees_by_salary_level`(`level_of_salary` VARCHAR(15))
BEGIN
SELECT em.`first_name`, em.`last_name`
FROM (SELECT e.`first_name`, e.`last_name`, `ufn_get_salary_level`(e.`salary`) AS `salary_level`
FROM `employees` AS e 
ORDER BY e.`first_name` DESC, e.`last_name` DESC) AS em
WHERE em.`salary_level` = `level_of_salary`;
END$$
DELIMITER ;

CALL `usp_get_employees_by_salary_level`('High');