SELECT 
    a.`airport_id`,
    a.`airport_name`,
    COUNT(c.`customer_id`) AS 'passengers'
FROM
    `airports` AS a
        INNER JOIN
    `flights` AS f ON f.`origin_airport_id` = a.`airport_id`
        INNER JOIN
    `tickets` AS t ON t.`flight_id` = f.`flight_id`
        INNER JOIN
    `customers` AS c ON c.`customer_id` = t.`customer_id`
WHERE
    f.`status` = 'Departing'
GROUP BY a.`airport_id`
ORDER BY a.`airport_id` ASC;