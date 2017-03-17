package cinema;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Viewing implements Comparable<Viewing> {
	private Film film;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	ArrayList<String> seats;
	
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
		
		return 0;
	}
	
	
}