USE `cinema`;
DROP procedure IF EXISTS `add_theater`;

DELIMITER $$
USE `cinema`$$
CREATE PROCEDURE `add_theater` (
	IN theaterId SMALLINT(5) UNSIGNED,
    IN seatColumns SMALLINT(5) UNSIGNED,
    IN seatRows SMALLINT(5) UNSIGNED
)
BEGIN
	INSERT INTO theater
    VALUES (theaterId, seatColumns, seatRows);
END$$
DELIMITER ;

DELIMITER $$
USE `cinema`$$
CREATE PROCEDURE `get_theater_by_id` (
	IN theaterId SMALLINT(5) UNSIGNED
)
BEGIN
	SELECT * FROM theater
    WHERE id = theaterID;
END$$
DELIMITER ;

DELIMITER $$
USE `cinema`$$
CREATE PROCEDURE `delete_theater` (
	IN theaterId SMALLINT(5) UNSIGNED
)
BEGIN
	DELETE FROM theater
	WHERE id = theaterID;

END$$
DELIMITER ;