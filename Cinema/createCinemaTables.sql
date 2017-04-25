USE cinema;

DROP TABLE IF EXISTS theater;

CREATE TABLE theater (
	id SMALLINT(5) UNSIGNED NOT NULL,
    seatRows SMALLINT(5) UNSIGNED NOT NULL,
    seatColumns SMALLINT(5) UNSIGNED NOT NULL,
    PRIMARY KEY(id)
) ENGINE=INNODB;

DROP TABLE IF EXISTS film;

CREATE TABLE film (
	title VARCHAR(50) NOT NULL,
    duration INT(5) UNSIGNED NOT NULL,
    description VARCHAR(50),
    genre VARCHAR(50) NOT NULL,
    release_year YEAR UNSIGNED NOT NULL,
    pgi SMALLINT(2) UNSIGNED NOT NULL,
    PRIMARY KEY(title)
) ENGINE=INNODB;

DROP TABLE IF EXISTS viewing;

CREATE TABLE viewing (
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

DROP TABLE IF EXISTS bookedSeat;

CREATE TABLE bookedSeat (
	id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	seatNumber SMALLINT(5) UNSIGNED NOT NULL,
	ticketID VARCHAR(50),
    viewingId SMALLINT(5) UNSIGNED NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FK_viewing
    FOREIGN KEY (viewingId) REFERENCES viewing(id)
		ON UPDATE CASCADE
		ON DELETE CASCADE
) ENGINE=INNODB;