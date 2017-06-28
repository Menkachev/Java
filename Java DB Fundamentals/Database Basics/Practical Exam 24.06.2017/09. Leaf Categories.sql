SELECT 
    c.`id`, c.`name`
FROM
    `categories` AS c
        LEFT JOIN
    `categories` AS ca ON c.`id` = ca.`parent_id`
WHERE
    ca.`id` IS NULL
ORDER BY c.`name` ASC , c.`id` ASC;