SELECT 
    e.`department_id`, SUM(e.`salary`) AS `total_salary`
FROM
    `employees` AS e
GROUP BY e.`department_id`;