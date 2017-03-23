USE `cinema`;
DROP PROCEDURE IF EXISTS `add_film`;

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

DROP PROCEDURE IF EXISTS `delete_film`;

DELIMITER $$
USE `cinema`$$
CREATE PROCEDURE `delete_film` (IN title VARCHAR(50))
BEGIN
	DELETE FROM film
    WHERE film.title=title;
END$$

DELIMITER ;

DROP PROCEDURE IF EXISTS `get_film_by_title`;

DELIMITER $$
USE `cinema`$$
CREATE PROCEDURE `get_film_by_title` (IN title VARCHAR(50))
BEGIN
	SELECT * FROM film
    WHERE film.title=title;
END$$

DELIMITER ;