package cinema;

import java.time.LocalDateTime;

/**
 * @author Herman
 *
 */
public class Viewing implements Comparable<Viewing> {
	private Film film;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String[] seats;

	/**
	 * The end time of the film will be calculated in this constructor.
	 * 
	 * @param film
	 *            - A reference to a film-object.
	 * @param startTime
	 *            - Start time, and date, of the film.
	 * @param seatAmount
	 *            - Amount of seats in the theater.
	 */
	public Viewing(Film film, LocalDateTime startTime, int seatAmount) {
		this.setFilm(film);
		this.setStartTime(startTime);
		setEndTime(startTime.plusMinutes(film.getLength().toMinutes()));
		seats = new String[seatAmount];
	}

	/**
	 * Overloaded constructor adapted for loading Strings from file. ish
	 */
	public Viewing(Film film, LocalDateTime startTime, String[] seats) {
		this.setFilm(film);
		this.setStartTime(startTime);
		setEndTime(startTime.plusMinutes(film.getLength().toMinutes()));
		this.seats = new String[seats.length];

		for (int i = 0; i < seats.length; i++) {
			this.seats[i] = seats[i];
		}
	}

	public boolean bookSeat(int seat, String ticketID) {
		boolean success;
		if (seats[seat] != null) {
			seats[seat] = ticketID;
			success = true;
		} else {
			success = false;
		}
		return success;
	}

	public boolean bookSeats(int seat, String ticketID, int seatCount) {
		return false;
	}

	Film getFilm() {
		return film;
	}

	void setFilm(Film film) {
		this.film = film;
	}

	LocalDateTime getStartTime() {
		return startTime;
	}

	void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	LocalDateTime getEndTime() {
		return endTime;
	}

	void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return 0 if o
	 */
	@Override
	public int compareTo(Viewing o) {
		int result;
		if (getStartTime().isBefore(o.getStartTime()) && getEndTime().isBefore(o.getStartTime()))
			result = -1;
		else if (getStartTime().isAfter(o.getEndTime())) {
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

	@Override
	public String toString() {
		return film.getTitle() + ", " + startTime.toString() + ", " + endTime.toString();
	}

	/**
	 * @return All data from Viewing, including all seats, and their respective
	 *         ticketID's.
	 */
	public String toFileString() {
		String fileString = "Viewing:" + film.getTitle() + "," + startTime.toString() + "Seats:";
		for (String seat : seats) {
			fileString += "," + seat;
		}
		return fileString;
	}
}