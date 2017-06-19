DROP FUNCTION IF EXISTS `ufn_is_word_comprised`;
DELIMITER $$
CREATE FUNCTION `ufn_is_word_comprised`(`set_of_letters` VARCHAR(50), `word` VARCHAR(30))
RETURNS BOOLEAN
BEGIN
   DECLARE `length` INT DEFAULT CHAR_LENGTH(`word`);
   DECLARE `index` INT DEFAULT 1;
    WHILE `index` <= `length`
    DO
      IF LOCATE(SUBSTRING(`word`, `index`, 1), `set_of_letters`) < 1 THEN
      RETURN FALSE;
      END IF;
      SET `index` = `index` + 1;
    END WHILE;
    RETURN TRUE;
END$$
DELIMITER ;