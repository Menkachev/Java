# 75 / 100

DELIMITER $$
CREATE PROCEDURE `udp_submit_review`(
                 `customer_id` INT, 
                 `review_content` VARCHAR(255), 
                 `review_grade` INT, 
                 `airline_name` VARCHAR(30))
BEGIN
      DECLARE `review_id` INT;
      DECLARE `airline_id` INT;
      SET `review_id` = (SELECT COUNT(*) FROM `customer_reviews`) + 1;
	  SET `airline_id` = (SELECT a.`airline_id` FROM `airlines` AS a WHERE a.`airline_name` = `airline_name`);

START TRANSACTION;

      INSERT INTO `customer_reviews`(`review_id`, `review_content`, `review_grade`, `airline_id`, `customer_id`)
      VALUES(`review_id`, `review_content`, `review_grade`, `review_id`, `customer_id`);

  IF (`airline_name` NOT IN(SELECT a.`airline_name` FROM `airlines` AS a)) THEN
	     SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Airline does not exist.';
         ROLLBACK;
  END IF;
  COMMIT;
END$$
DELIMITER ;