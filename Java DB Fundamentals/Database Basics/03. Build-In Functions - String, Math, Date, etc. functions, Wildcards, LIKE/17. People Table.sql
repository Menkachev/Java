CREATE DATABASE `ages`;

CREATE TABLE `people` (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(15),
    birthdate DATETIME
);

INSERT INTO `people` VALUES(1, 'Viktor', '2000-12-07 00:00:00'),
                           (2, 'Steven', '1992-09-10 00:00:00'),
                           (3, 'Stephen', '1910-09-19 00:00:00'),
                           (4, 'John', '2010-01-06 00:00:00');
                           
SELECT 
    `name`,
    TIMESTAMPDIFF(YEAR, `birthdate`, NOW()) AS `age_in_years`,
    TIMESTAMPDIFF(MONTH, `birthdate`, NOW()) AS `age_in_months`,
    TIMESTAMPDIFF(DAY, `birthdate`, NOW()) AS `age_in_days`,
    TIMESTAMPDIFF(MINUTE, `birthdate`, NOW()) AS `age_in_minutes`
FROM
    `people`;