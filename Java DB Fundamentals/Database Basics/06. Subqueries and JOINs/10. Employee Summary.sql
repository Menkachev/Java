# 10

SELECT 
    e.`employee_id`,
    CONCAT(e.`first_name`, ' ', e.`last_name`) AS 'employee_name',
    CONCAT(mn.`first_name`, ' ', mn.`last_name`) AS 'manager_name',
    d.`name` AS 'department_name'
FROM
    `employees` AS e
        INNER JOIN
    `employees` AS mn ON mn.`employee_id` = e.`manager_id`
        INNER JOIN
    `departments` AS d ON e.`department_id` = d.`department_id`
ORDER BY e.`employee_id`
LIMIT 5;