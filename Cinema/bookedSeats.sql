#Bookedseats (fill_list, get_seat_by_id, clear_by_viewing)
USE cinema;
DELIMITER $$
USE `cinema`$$
create procedure `add_seat` (
IN id int(10) UNSIGNED, 
IN tickedID VARCHAR(50),
IN seatNUmber SMALLINT(5) UNSIGNED,
IN viewingID SMALLINT(5) UNSIGNED)
BEGIN
INSERT INTO bookedseat
VALUES(id, seatNumber, ticketid, viewingID);

 

END $$

DELIMITER ;


DELIMITER $$
USE `cinema`$$
CREATE PROCEDURE `get_seat_by_id`(
in id INT (10)UNSIGNED)

BEGIN
SELECT * FROM bookedseat
WHERE bookedseat.id = id;

END $$
DELIMITER ;

DELIMITER $$
USE `cinema`$$
create procedure `clear_by_viewing`(

IN viewingID SMALLINT (5) UNSIGNED

)
BEGIN
DELETE FROM bookedseat 
WHERE bookedseat.viewingID = viewingID;
END $$

DELIMITER ;


USE cinema;
DELIMITER $$
USE `cinema`$$
CREATE PROCEDURE `get_seat_by_viewing` (
IN viewingID SMALLINT (5) UNSIGNED)
BEGIN
SELECT * FROM bookedseat
WHERE bookedseat.viewingID = viewingID;
END$$
DELIMITER ;

