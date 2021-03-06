CREATE TABLE `avg_salaries` AS
SELECT 
    *
FROM
    `employees` AS e
WHERE
    e.`salary` > 30000;
    
DELETE FROM `avg_salaries` 
WHERE
    `manager_id` = 42;
    
UPDATE `avg_salaries` 
SET 
    `salary` = `salary` + 5000
WHERE
    `department_id` = 1;
    
    SELECT 
    `department_id`, AVG(`salary`)
FROM
    `avg_salaries`
GROUP BY `department_id`;