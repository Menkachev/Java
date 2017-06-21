SELECT 
    c.`customer_id`,
    CONCAT(c.`first_name`, ' ', c.`last_name`) AS 'full_name',
    t.`price` AS 'ticket_price',
    a.`airport_name` AS 'destination'
FROM
    `customers` AS c
        INNER JOIN
    `tickets` AS t ON c.`customer_id` = t.`customer_id`
        INNER JOIN
    `flights` AS f ON t.`flight_id` = f.`flight_id`
        INNER JOIN
    `airports` AS a ON f.`destination_airport_id` = a.`airport_id`
WHERE
    f.`status` = 'Delayed'
ORDER BY t.`price` DESC, c.`customer_id`
LIMIT 3;
    