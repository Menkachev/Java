SELECT 
    `name`, DATE_FORMAT(`start`, '%Y-%m-%d') AS `date`
FROM
    `games`
WHERE
    EXTRACT(YEAR FROM `start`) BETWEEN 2011 AND 2012
ORDER BY `date` , `name`
LIMIT 50;