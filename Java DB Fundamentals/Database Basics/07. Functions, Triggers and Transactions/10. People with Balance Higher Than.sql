DROP PROCEDURE IF EXISTS  `usp_get_holders_with_balance_higher_than`;
DELIMITER $$
CREATE PROCEDURE `usp_get_holders_with_balance_higher_than`(IN `num` DECIMAL(19,4))
BEGIN
SELECT ah.`first_name`, ah.`last_name` 
FROM `account_holders` AS ah
INNER JOIN `accounts` AS a ON ah.`id` = a.`account_holder_id` 
GROUP BY a.`account_holder_id`
HAVING SUM(a.`balance`) > `num`
ORDER BY ah.`first_name`, ah.`last_name`;
END$$
DELIMITER ;

CALL `usp_get_holders_with_balance_higher_than`(7000);