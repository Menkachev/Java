DELIMITER $$
CREATE FUNCTION `udf_get_radians`(`degrees` FLOAT)
RETURNS FLOAT 
BEGIN
DECLARE `radians` FLOAT;
SET `radians` = (PI() * `degrees`) / 180;
RETURN `radians`;
END$$
DELIMITER ;

SELECT `udf_get_radians`(22.12) AS `radians`; 

# answer: 0.38606685400009155