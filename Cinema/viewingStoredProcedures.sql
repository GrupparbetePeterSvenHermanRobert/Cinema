USE `cinema`;
DROP procedure IF EXISTS `get_Viewing`;

DELIMITER $$
USE `cinema`$$
CREATE PROCEDURE `get_Viewing`(
	IN Viewing_Id SMALLINT(5) UNSIGNED
	
)
BEGIN
	select *
    from viewing
	WHERE viewingId= id;
   
END$$

DELIMITER ;

USE `cinema`;
DROP procedure IF EXISTS `add_Viewing`;

DELIMITER $$
USE `cinema`$$
CREATE PROCEDURE `add_Viewing`(
	IN id SMALLINT(5) UNSIGNED,
    IN filmTitle VARCHAR(50),
    IN startTime Datetime,
    IN endTime DateTime,
    IN theaterId SMALLINT(5) UNSIGNED
    
)
BEGIN
	INSERT  INTO Viewing 
	VALUE ( id, filmTitle, startTime, endTime, TheaterID);
   
END$$

DELIMITER ;
