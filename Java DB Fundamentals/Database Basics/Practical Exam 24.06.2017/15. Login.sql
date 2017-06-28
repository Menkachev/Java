DELIMITER $$
CREATE PROCEDURE `udp_login`(`username` VARCHAR(30), `password` VARCHAR(30))
BEGIN

IF (`username` NOT IN(SELECT u.`username` FROM `users` AS u)) THEN
	     SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Username does not exist!';
         ROLLBACK;
  END IF;
  
  IF (`password` NOT IN(SELECT u.`password` FROM `users` AS u)) THEN
	     SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Password is incorrect!';
         ROLLBACK;
  END IF;
  
  IF (`username` IN(SELECT lu.`username` FROM `logged_in_users` AS lu)) THEN
	     SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'User is already logged in!';
         ROLLBACK;
  END IF;
  
  INSERT INTO `logged_in_users`(`id`, `username`, `password`, `email`)
  VALUES((SELECT u.`id` FROM `users` AS u WHERE `username` = u.`username`), 
  `username`, `password`, (SELECT u.`email` FROM `users` AS u WHERE `username` = u.`username`));

END$$
DELIMITER ;