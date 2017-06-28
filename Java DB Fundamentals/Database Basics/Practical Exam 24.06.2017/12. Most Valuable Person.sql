SELECT 
    s.`id`,
    u.`username`,
    p.`name`,
    CONCAT(s.`passed_tests`, ' / ', p.`tests`) AS 'result'
FROM
    `users` AS u
        INNER JOIN
    (SELECT 
        u.`id`, u.`username`, COUNT(uc.`contest_id`) AS 'contests'
    FROM
        `users` AS u
    INNER JOIN `users_contests` AS uc ON u.`id` = uc.`user_id`
    GROUP BY u.`id`
    ORDER BY `contests` DESC
    LIMIT 1) AS temp ON u.`id` = temp.`id`
        INNER JOIN
    `submissions` AS s ON s.`user_id` = u.`id`
        INNER JOIN
    `problems` AS p ON p.`id` = s.`problem_id`
ORDER BY s.`id` DESC;