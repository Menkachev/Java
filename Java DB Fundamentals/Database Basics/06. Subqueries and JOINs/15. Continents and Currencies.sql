SELECT 
    `table1`.`continent_code`,
    `table1`.`currency_code`,
    `table1`.`currency_usage`
FROM
    (SELECT 
        co.`continent_code`,
            cu.`currency_code`,
            COUNT(c.`currency_code`) AS 'currency_usage'
    FROM
        `continents` AS co
    INNER JOIN `countries` AS c ON co.`continent_code` = c.`continent_code`
    INNER JOIN `currencies` AS cu ON c.`currency_code` = cu.`currency_code`
    GROUP BY co.`continent_code` , cu.`currency_code`
    HAVING `currency_usage` > 1) AS `table1`
        INNER JOIN
    (SELECT 
        `co_usage`.`continent_code`,
            MAX(`co_usage`.`currency_usage`) AS 'max_usage'
    FROM
        (SELECT 
        co.`continent_code`,
            cu.`currency_code`,
            COUNT(c.`currency_code`) AS 'currency_usage'
    FROM
        `continents` AS co
    INNER JOIN `countries` AS c ON co.`continent_code` = c.`continent_code`
    INNER JOIN `currencies` AS cu ON c.`currency_code` = cu.`currency_code`
    GROUP BY co.`continent_code` , cu.`currency_code`
    HAVING `currency_usage` > 1) AS `co_usage`
    GROUP BY `co_usage`.`continent_code`) AS `table2` ON `table1`.`continent_code` = `table2`.`continent_code`
WHERE
    `table1`.`currency_usage` = `table2`.`max_usage`
ORDER BY `table1`.`continent_code` , `table1`.`currency_code`;