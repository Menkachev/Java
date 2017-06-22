DELIMITER $$
CREATE PROCEDURE `udp_send_message`(`user_id` INT(11), `chat_id` INT(11), `content` VARCHAR(200))
BEGIN

INSERT INTO `messages`(`content`, `sent_on`, `chat_id`, `user_id`)
VALUES(`content`, '2016-12-15', `chat_id`, `user_id`);

  IF (`user_id` NOT IN(SELECT m.`user_id` FROM `messages` AS m)) THEN
	     SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'There is no chat with that user!';
         ROLLBACK;
  END IF;
END$$
DELIMITER ;