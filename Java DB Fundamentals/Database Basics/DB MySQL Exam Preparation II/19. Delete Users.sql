DELIMITER $$
CREATE TRIGGER `tr_delete_user`
BEFORE DELETE
ON `users`
FOR EACH ROW
BEGIN

IF(SELECT u.`id` FROM `users` AS u WHERE u.`id` = OLD.`id`) THEN

DELETE FROM `users_chats` 
WHERE `user_id` = OLD.`id`;

DELETE FROM `messages` 
WHERE `user_id` = OLD.`id`;

DELETE FROM `messages_log` 
WHERE `user_id` = OLD.`id`;

END IF;

END$$
DELIMITER ;