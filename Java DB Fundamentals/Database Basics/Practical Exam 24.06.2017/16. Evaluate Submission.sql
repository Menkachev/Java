DELIMITER $$
CREATE PROCEDURE `udp_evaluate`(`id` INT)
BEGIN

  IF (`id` NOT IN(SELECT s.`id` FROM `submissions` AS s)) THEN
	     SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Submission does not exist!';
         ROLLBACK;
  END IF;

INSERT INTO `evaluated_submissions`(`id`, `problem`, `user`, `result`)
SELECT 
s.`id`, 
p.`name`, 
u.`username`, 
CEILING(p.`points` / p.`tests` * s.`passed_tests`)
FROM `submissions` AS s 
INNER JOIN `problems` AS p ON s.`problem_id` = p.`id`
INNER JOIN `users` AS u ON s.`user_id` = u.`id` 
WHERE s.`id` = `id`;

END$$
DELIMITER ;

call `udp_evaluate`(1);