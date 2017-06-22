SELECT 
    u.`nickname`, c.`title`, l.`latitude`, l.`longitude`
FROM
    `users` u
        INNER JOIN
    `locations` AS l ON u.`location_id` = l.`id`
        INNER JOIN
    `users_chats` AS uc ON u.`id` = uc.`user_id`
        INNER JOIN
    `chats` AS c ON c.`id` = uc.`chat_id`
WHERE
    (l.`latitude` BETWEEN 41.139999 AND 44.129999)
        && (l.`longitude` BETWEEN 22.209999 AND 28.359999)
ORDER BY c.`title` ASC;