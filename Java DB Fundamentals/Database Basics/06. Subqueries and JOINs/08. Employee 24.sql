SELECT 
    e.`employee_id`,
    e.`first_name`,
    CASE
        WHEN YEAR(p.`start_date`) > 2004 THEN p.`name` = NULL
        ELSE p.`name`
    END AS 'project_name'
FROM
    `employees` AS e
        INNER JOIN
    `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
        INNER JOIN
    `projects` AS p ON ep.`project_id` = p.`project_id`
WHERE
    e.`employee_id` = 24
ORDER BY `project_name`;
