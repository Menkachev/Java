CREATE TABLE `game_duration` AS 
SELECT 
    `name`,
    HOUR(`start`) AS `hours`,
    `duration`
FROM
    `games`;
    
ALTER TABLE `game_duration` 
ADD COLUMN `part_of_the_day` VARCHAR(50);

ALTER TABLE `game_duration`
ADD COLUMN `game_length` VARCHAR(20);
    
UPDATE `game_duration` 
SET 
    `part_of_the_day` = 'Morning'
WHERE
    `hours` >= 0
        AND `hours` < 12;
        
UPDATE `game_duration` 
SET 
    `part_of_the_day` = 'Afternoon'
WHERE
    `hours` >= 12
        AND `hours` < 18;
        
UPDATE `game_duration` 
SET 
    `part_of_the_day` = 'Evening'
WHERE
    `hours` >= 18
        AND `hours` < 24;
        
UPDATE `game_duration` 
SET 
    `game_length` = 'Extra Short'
WHERE
    `duration` <= 3;

UPDATE `game_duration` 
SET 
    `game_length` = 'Short'
WHERE
    `duration` > 3 AND `duration` <= 6;
    
UPDATE `game_duration` 
SET 
    `game_length` = 'Long'
WHERE
    `duration` > 6 AND `duration` <= 10;
    
UPDATE `game_duration` 
SET 
    `game_length` = 'Extra Long'
WHERE
    `duration` > 10 OR `duration` IS NULL;
    
SELECT 
    `name` AS 'game',
    `part_of_the_day` AS 'Part of the Day',
    `game_length` AS 'Duration'
FROM
    `game_duration`
ORDER BY `name`;