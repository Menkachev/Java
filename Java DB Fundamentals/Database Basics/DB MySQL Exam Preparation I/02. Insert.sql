INSERT INTO `flights`
(`departure_time`, `arrival_time`, `status`, `origin_airport_id`, `destination_airport_id`, `airline_id`)
SELECT  
'2017-06-19 14:00:00',
'2017-06-21 11:00:00',
CASE a.`airline_id` % 4 
     WHEN 0 THEN 'Departing'
     WHEN 1 THEN 'Delayed'
     WHEN 2 THEN 'Arrived'
     WHEN 3 THEN 'Canceled'
     END,
CEILING(SQRT(CHAR_LENGTH(a.`airline_name`))),
CEILING(SQRT(CHAR_LENGTH(a.`nationality`))),
a.`airline_id`
FROM `airlines` AS a
WHERE a.`airline_id` BETWEEN 1 AND 10;