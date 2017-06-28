SELECT 
    c.`id`, c.`name`, COUNT(s.`id`) AS `submissions`
FROM
    `contests` AS c
        INNER JOIN
    `problems` AS p ON c.`id` = p.`contest_id`
        INNER JOIN
    `submissions` AS s ON p.`id` = s.`problem_id`
        INNER JOIN
    `users` AS u ON u.`id` = s.`user_id`
        LEFT JOIN
    `users_contests` AS uc ON uc.`contest_id` = c.`id`
WHERE
    uc.`user_id` = u.`id`
GROUP BY c.`id`
ORDER BY `submissions` DESC , c.`id` ASC;