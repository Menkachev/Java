SELECT 
    wd.`deposit_group`, SUM(wd.`deposit_amount`) AS 'total_sum'
FROM
    `wizzard_deposits` AS wd
WHERE
    wd.`magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`;