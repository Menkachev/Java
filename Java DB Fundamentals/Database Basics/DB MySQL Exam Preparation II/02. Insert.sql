INSERT INTO `messages`(`content`, `sent_on`, `chat_id`, `user_id`) 
SELECT 
CONCAT(u.`age`, '-', u.`gender`, '-', l.`latitude`, '-', l.`longitude`),
 '2016-12-15',
 CASE u.`gender`
      WHEN 'F' THEN CEILING(SQRT(u.`age` * 2))
      WHEN 'M' THEN POW((u.`age` / 18), 3)
END,
u.`id`
FROM `users` AS u 
INNER JOIN `locations` AS l ON u.`location_id` = l.`id`
WHERE u.`id` >= 10 AND u.`id` <= 20;