DELIMITER $$
CREATE PROCEDURE `udp_purchase_ticket`(
                 `customer_id` INT(11), 
                 `flight_id` INT(11), 
                 `ticket_price` DECIMAL(10, 2), 
                 `class` VARCHAR(6), 
                 `seat` VARCHAR(5))
BEGIN
      DECLARE `customer_balance` DECIMAL(10, 2);
      SET `customer_balance` = (SELECT cba.`balance` FROM `customer_bank_accounts` AS cba 
                                                     WHERE cba.`customer_id` = `customer_id`);

START TRANSACTION;

      INSERT INTO `tickets`(`customer_id`, `flight_id`, `price`, `class`, `seat`)
      VALUES(`customer_id`, `flight_id`, `ticket_price`, `class`, `seat`);

  IF (`ticket_price` > `customer_balance`) THEN
      SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Insufficient bank account balance for ticket purchase.';
      ROLLBACK;
  ELSE
      COMMIT;
  END IF;

UPDATE `customer_bank_accounts` 
SET 
    `balance` = `balance` - `ticket_price`
WHERE
    `customer_id` = `customer_id`;
    
END$$

DELIMITER ;