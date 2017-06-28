DELETE FROM `users` 
WHERE
    `id` IN (SELECT * FROM
        (SELECT 
            u.`id`
        FROM
            `users` AS u
        LEFT JOIN `users_contests` AS uc ON u.`id` = uc.`user_id`
        
        WHERE
            uc.`user_id` IS NULL) AS temp);