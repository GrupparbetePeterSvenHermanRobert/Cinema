CREATE SCHEMA `cinema`;
USE cinema;

CREATE TABLE IF NOT EXISTS theater (
	id SMALLINT(5) UNSIGNED NOT NULL,
    seatRows SMALLINT(5) UNSIGNED NOT NULL,
    seatColumns SMALLINT(5) UNSIGNED NOT NULL,
    PRIMARY KEY(id)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS film (
	title VARCHAR(50) NOT NULL,
    duration INT(5) UNSIGNED NOT NULL,
    description VARCHAR(50),
    PRIMARY KEY(title)
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS viewing (
	id SMALLINT(5) UNSIGNED NOT NULL,
	filmTitle VARCHAR(50) NOT NULL,
    startTime DATETIME NOT NULL,
    endTime DATETIME NOT NULL,
    theaterId SMALLINT(5) UNSIGNED NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FK_theater
    FOREIGN KEY (theaterId) REFERENCES theater(id)
		ON UPDATE CASCADE
		ON DELETE RESTRICT,
	CONSTRAINT FK_film
    FOREIGN KEY (filmTitle) REFERENCES film(title)
		ON UPDATE CASCADE
		ON DELETE RESTRICT
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS bookedSeat (
	id SMALLINT(5) UNSIGNED NOT NULL,
	ticketID VARCHAR(50),
    viewingId SMALLINT(5) UNSIGNED NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FK_viewing
    FOREIGN KEY (viewingId) REFERENCES viewing(id)
		ON UPDATE CASCADE
		ON DELETE RESTRICT
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS ticket (
	id VARCHAR(50) NOT NULL,
    seatId SMALLINT(5) UNSIGNED NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FK_seat
    FOREIGN KEY (seatId) REFERENCES bookedSeat(id)
		ON UPDATE CASCADE
		ON DELETE RESTRICT
) ENGINE=INNODB;