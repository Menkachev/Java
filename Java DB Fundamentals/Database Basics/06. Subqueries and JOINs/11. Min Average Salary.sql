SELECT 
    MIN(t.`min_salary`) AS 'min_avg_salary'
FROM
    (SELECT 
        AVG(e.`salary`) AS 'min_salary'
    FROM
        `employees` AS e
    GROUP BY e.`department_id`) AS t;