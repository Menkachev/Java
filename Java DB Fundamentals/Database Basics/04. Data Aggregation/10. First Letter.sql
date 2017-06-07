SELECT 
    DISTINCT(LEFT(wd.`first_name`, 1)) AS `first_letter`
FROM
    `wizzard_deposits` AS wd
WHERE
    wd.`deposit_group` = 'Troll Chest'
GROUP BY wd.`first_name`
ORDER BY wd.`first_name`;