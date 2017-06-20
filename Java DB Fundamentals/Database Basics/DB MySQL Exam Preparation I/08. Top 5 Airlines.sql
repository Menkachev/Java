SELECT 
    a.`airline_id`,
    a.`airline_name`,
    a.`nationality`,
    a.`rating`
FROM
    `airlines` AS a
WHERE
    (SELECT 
            COUNT(f.`flight_id`)
        FROM
            `flights` AS f
        WHERE
            a.`airline_id` = f.`airline_id`) > 0
ORDER BY a.`rating` DESC
LIMIT 5;