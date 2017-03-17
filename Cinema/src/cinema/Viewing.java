/*
 * @Author Herman
 * @Version 0.1
 */

package cinema;

import java.time.LocalDateTime;

public class Viewing implements Comparable<Viewing> {
	private Film film;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String[] seats;
	
	public Viewing(Film film, LocalDateTime startTime, int seatAmount) {
		this.setFilm(film);
		this.setStartTime(startTime);
		setEndTime(startTime.plusMinutes(film.getLength().toMinutes()));
		seats = new String[seatAmount];
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
		return film.getTitle() + "," + startTime.toString() + "," + endTime.toString();
	}
	
	public String toFileString() {
		String fileString = film.getTitle()	+ "," + startTime.toString() + "," + endTime.toString();
		for (String seat : seats) {
			fileString += "," + seat;
		}
		return fileString;
	}
}