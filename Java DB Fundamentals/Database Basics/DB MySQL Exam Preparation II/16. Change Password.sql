DELIMITER $$
CREATE PROCEDURE `udp_change_password`(`email` VARCHAR(30), `password` VARCHAR(20))
BEGIN

START TRANSACTION;

UPDATE `credentials`
SET `credentials`.`password` = `password`
WHERE `credentials`.`email` = `email`;

  IF (`email` NOT IN(SELECT c.`email` FROM `credentials` AS c)) THEN
	     SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The email does\'t exist!.';
         ROLLBACK;
  END IF;
  COMMIT;
  
END$$
DELIMITER ;

