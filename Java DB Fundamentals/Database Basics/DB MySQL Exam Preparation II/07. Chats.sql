SELECT 
    c.`title`, c.`is_active`
FROM
    `chats` AS c
WHERE
    c.`is_active` = 0
        AND CHAR_LENGTH(c.`title`) < 5
        OR LOCATE('tl', c.`title`, 3)
ORDER BY c.`title` DESC;