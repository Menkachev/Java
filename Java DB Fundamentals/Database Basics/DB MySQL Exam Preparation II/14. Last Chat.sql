SELECT 
    c.`title`, m.`content`
FROM
    `chats` AS c
        INNER JOIN
    `messages` AS m ON c.`id` = m.`chat_id`
WHERE
    c.`id` = (SELECT 
            c.`id`
        FROM
            `chats` AS c
        ORDER BY c.`start_date` DESC
        LIMIT 1)
ORDER BY m.`sent_on` , m.`id` ASC;