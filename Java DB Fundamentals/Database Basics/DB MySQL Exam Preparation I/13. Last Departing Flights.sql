SELECT 
    *
FROM
    (SELECT 
        f.`flight_id`,
            f.`departure_time`,
            f.`arrival_time`,
            origin_airport.`airport_name` AS 'origin',
            destination.`airport_name` AS 'destination'
    FROM
        `flights` AS f
    INNER JOIN `airports` AS origin_airport ON f.`origin_airport_id` = origin_airport.`airport_id`
    INNER JOIN `airports` AS destination ON f.`destination_airport_id` = destination.`airport_id`
    WHERE
        f.`status` = 'Departing'
    ORDER BY f.`departure_time` DESC
    LIMIT 5) AS table1
ORDER BY table1.`departure_time` ASC , table1.`flight_id` ASC;