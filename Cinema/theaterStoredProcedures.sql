USE `cinema`;
DROP procedure IF EXISTS `add_theater`;

DELIMITER $$
USE `cinema`$$
CREATE PROCEDURE `add_theater` (
	IN theaterId INT,
    IN seatColumns INT,
    IN seatRows INT
)
BEGIN
	INSERT INTO theater
    VALUES (theaterId, seatColumns, seatRows);
END$$
DELIMITER ;

DELIMITER $$
USE `cinema`$$
CREATE PROCEDURE `get_theater_by_id` (
	IN theaterId INT
)
BEGIN
	SELECT * FROM theater
    WHERE id = theaterID;
END$$
DELIMITER ;

DELIMITER $$
USE `cinema`$$
CREATE PROCEDURE `delete_theater` (
	IN theaterId INT
)
BEGIN
	DELETE FROM theater
	WHERE id = theaterID;

END$$
DELIMITER ;