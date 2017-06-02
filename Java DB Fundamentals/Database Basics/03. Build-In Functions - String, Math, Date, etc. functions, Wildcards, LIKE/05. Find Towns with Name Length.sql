SELECT 
    `name`
FROM
    `towns`
WHERE
    CHAR_LENGTH(`name`) <= 6  
ORDER BY `name` ASC;