SELECT 
    `town_id`, `name`
FROM
    `towns`
WHERE
    LEFT(`name`, 1) NOT IN ('R', 'D', 'B')
ORDER BY `name`;