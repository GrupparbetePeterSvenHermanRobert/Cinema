USE `cinema`;
DROP procedure IF EXISTS `add_film`;

DELIMITER $$
USE `cinema`$$
CREATE PROCEDURE `add_film` (
	IN filmname VARCHAR(50),
    IN description VARCHAR(50),
    IN duration INT
)
BEGIN
	INSERT INTO film
    VALUES (filmname, description, duration);
END$$

DELIMITER ;

DROP procedure IF EXISTS `add_film`;

DELIMITER $$
USE `cinema`$$
CREATE PROCEDURE `add_film` (
	IN filmname VARCHAR(50),
    IN description VARCHAR(50),
    IN duration INT
)
BEGIN
	INSERT INTO film
    VALUES (filmname, description, duration);
END$$

DELIMITER ;