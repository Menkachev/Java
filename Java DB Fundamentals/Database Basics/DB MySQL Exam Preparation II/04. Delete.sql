DELETE FROM `locations` 
WHERE
    `id` IN (SELECT 
        temp.id
    FROM
        (SELECT 
            l.`id`
        FROM
            `locations` AS l
        LEFT JOIN `users` AS u ON l.`id` = u.`location_id`
        GROUP BY l.`id`
        HAVING
            COUNT(u.`id`) = 0) AS temp);