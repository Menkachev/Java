SELECT 
    mc.`country_code`,
    m.`mountain_range`,
    p.`peak_name`,
    p.`elevation`
FROM
    `mountains_countries` AS mc
        INNER JOIN
    `peaks` AS p ON mc.`mountain_id` = p.`mountain_id`
        INNER JOIN
    `mountains` AS m ON p.`mountain_id` = m.`id`
WHERE
    mc.`country_code` = 'BG'
        AND p.`elevation` > 2835
ORDER BY p.`elevation` DESC;