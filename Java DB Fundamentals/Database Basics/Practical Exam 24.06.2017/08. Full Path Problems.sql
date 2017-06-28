SELECT 
    p.`id`,
    CONCAT(c.`name`, ' - ', con.`name`, ' - ', p.`name`) AS `full_path`
FROM
    `problems` AS p
        INNER JOIN
    `contests` AS con ON p.`contest_id` = con.`id`
        INNER JOIN
    `categories` AS c ON con.`category_id` = c.`id`
ORDER BY p.`id` ASC;