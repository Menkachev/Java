UPDATE `employees` 
SET 
    `salary` = `salary` * 1.12
WHERE
    `department_id` IN (11, 4, 2, 1);
        
        SELECT 
    `salary` 
FROM
    `employees`;
