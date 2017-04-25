USE `cinema`;
DROP PROCEDURE IF EXISTS `add_film`;

DELIMITER $$
USE `cinema`$$
CREATE PROCEDURE `add_film` (
	IN filmtitle VARCHAR(50),
    IN description VARCHAR(50),
    IN duration INT,
    IN genre VARCHAR(50),
    IN release_year YEAR,
    IN pgi INT
)
BEGIN
	INSERT INTO film
    VALUES (filmtitle, duration, description, genre, release_year, pgi);
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
    WHERE film.title=title
    COLLATE utf8_swedish_ci;
END$$

DELIMITER ;

DROP PROCEDURE IF EXISTS `get_films_by_filter`;

DELIMITER $$
USE `cinema` $$
CREATE PROCEDURE `get_films_by_filter` (IN filter VARCHAR(50))
BEGIN
	SELECT * FROM film
    WHERE film.title LIKE filter
    COLLATE utf8_swedish_ci
    ORDER BY title ASC;
END $$

DROP PROCEDURE IF EXISTS `get_films_order_by_title`;

DELIMITER $$
USE `cinema` $$
CREATE PROCEDURE `get_films_order_by_title` ()
BEGIN
	SELECT * FROM film
    ORDER BY title ASC;
END $$

DELIMITER ;

DROP PROCEDURE IF EXISTS `get_films_order_by_title_desc`;

DELIMITER $$
USE `cinema` $$
CREATE PROCEDURE `get_films_order_by_title_desc` ()
BEGIN
	SELECT * FROM film
    ORDER BY title DESC;
END $$

DELIMITER ;