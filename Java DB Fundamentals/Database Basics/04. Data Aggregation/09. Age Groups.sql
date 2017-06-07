ALTER TABLE `wizzard_deposits`
ADD COLUMN `age_group` VARCHAR(15);

UPDATE `wizzard_deposits`
SET `age_group` = '[0-10]' WHERE `age` <= 10;

UPDATE `wizzard_deposits`
SET `age_group` = '[11-20]' WHERE `age` > 10 && `age` <= 20;

UPDATE `wizzard_deposits`
SET `age_group` = '[21-30]' WHERE `age` > 20 && `age` <= 30;

UPDATE `wizzard_deposits`
SET `age_group` = '[31-40]' WHERE `age` > 30 && `age` <= 40;

UPDATE `wizzard_deposits`
SET `age_group` = '[41-50]' WHERE `age` > 40 && `age` <= 50;

UPDATE `wizzard_deposits`
SET `age_group` = '[51-60]' WHERE `age` > 50 && `age` <= 60;

UPDATE `wizzard_deposits`
SET `age_group` = '[61+]' WHERE `age` > 60;

SELECT 
    wd.`age_group`, COUNT(wd.`age_group`) AS `wizard_count`
FROM
    `wizzard_deposits` AS wd
    GROUP BY wd.`age_group`;