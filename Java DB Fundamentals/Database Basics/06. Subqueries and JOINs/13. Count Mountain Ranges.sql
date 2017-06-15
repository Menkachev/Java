SELECT 
    c.`country_code`,
    COUNT(mc.`mountain_id`) AS 'mountain_range'
FROM
    `countries` AS c
        INNER JOIN
    `mountains_countries` AS mc ON c.`country_code` = mc.`country_code`
WHERE
    c.`country_code` IN ('US' , 'RU', 'BG')
GROUP BY c.`country_code`
ORDER BY `mountain_range` DESC;