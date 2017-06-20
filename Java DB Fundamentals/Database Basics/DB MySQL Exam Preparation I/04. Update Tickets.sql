UPDATE `tickets`
SET `price` = `price` * 1.5
WHERE `tickets`.`flight_id` IN (SELECT f.`flight_id` FROM `flights` AS f 
	  WHERE f.`airline_id` = (SELECT a.`airline_id` FROM `airlines` AS a
	  WHERE a.`rating` = (SELECT MAX(a.`rating`) FROM `airlines` AS a)));