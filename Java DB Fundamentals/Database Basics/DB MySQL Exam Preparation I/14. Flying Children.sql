SELECT 
    c.`customer_id`,
    CONCAT(c.`first_name`, ' ', c.`last_name`) AS 'full_name',
    TIMESTAMPDIFF(YEAR,
        c.`date_of_birth`,
        '2016-12-31') AS 'age'
FROM
    `customers` AS c
        INNER JOIN
    `tickets` AS t ON c.`customer_id` = t.`customer_id`
        INNER JOIN
    `flights` AS f ON t.`flight_id` = f.`flight_id`
WHERE
    f.`status` = 'Arrived'
        AND TIMESTAMPDIFF(YEAR,
        c.`date_of_birth`,
        '2016-12-31') < 21
GROUP BY c.`customer_id`
ORDER BY `age` DESC , c.`customer_id` ASC;