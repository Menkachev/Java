SELECT 
    m.`content`, m.`sent_on`
FROM
    `messages` AS m
WHERE
    m.`sent_on` > '2014-05-12'
        AND (SELECT LOCATE('just', m.`content`))
ORDER BY m.`id` DESC;