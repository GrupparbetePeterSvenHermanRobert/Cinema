/*
 * @Author Herman
 * @Version 0.1
 */

package cinema;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Viewing implements Comparable<Viewing> {
	private Film film;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private ArrayList<String> seats;
	
	
	public Viewing(Film film, LocalDateTime startTime) {
		this.setFilm(film);
		this.setStartTime(startTime);
		setEndTime(startTime.plusMinutes(film.getLength().toMinutes()));
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
		return "";
	}
}