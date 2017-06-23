DELIMITER $$
CREATE TRIGGER `tr_delete_messages`
AFTER DELETE
ON `messages`
FOR EACH ROW
BEGIN

INSERT INTO `messages_log`(`id`, `content`, `sent_on`, `chat_id`, `user_id`)
VALUES(old.`id`, old.`content`, old.`sent_on`, old.`chat_id`, old.`user_id`); 

END$$
DELIMITER ;