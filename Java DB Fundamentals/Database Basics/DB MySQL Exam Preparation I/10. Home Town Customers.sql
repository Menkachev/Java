SELECT DISTINCT
    c.`customer_id`,
    CONCAT(c.`first_name`, ' ', c.`last_name`) AS `full_name`,
    town.`town_name` AS `home_town`
FROM
    `customers` AS c
        INNER JOIN
    `tickets` AS t ON c.`customer_id` = t.`customer_id`
        INNER JOIN
    `flights` AS f ON t.`flight_id` = f.`flight_id`
        INNER JOIN
    `airports` AS a ON a.`airport_id` = f.`origin_airport_id`
        INNER JOIN
    `towns` AS town ON a.`town_id` = town.`town_id`
WHERE
    c.`home_town_id` = town.`town_id`
        AND f.`status` = 'Departing'
ORDER BY c.`customer_id` ASC;