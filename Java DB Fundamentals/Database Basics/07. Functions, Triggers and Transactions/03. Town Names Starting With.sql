DELIMITER $$
CREATE PROCEDURE
`usp_get_towns_starting_with`(`town_starting_with` VARCHAR(25))
BEGIN
SELECT t.`name` FROM `towns` AS t 
WHERE t.`name` LIKE (CONCAT(`town_starting_with`, '', '%')) 
ORDER BY t.`name`;
END$$
DELIMITER ;