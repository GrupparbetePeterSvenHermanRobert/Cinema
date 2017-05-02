package storage;

import cinema.Film;
import cinema.Theater;
import cinema.Viewing;

public class TheaterViewingFilmContainer {

	private Theater theater;
	private Viewing viewing;
	private Film film;
	
	public Theater getTheater() {
		return theater;
	}
	
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	
	public Viewing getViewing() {
		return viewing;
	}
	
	public void setViewing(Viewing viewing) {
		this.viewing = viewing;
	}
	
	public Film getFilm() {
		return film;
	}
	
	public void setFilm(Film film) {
		this.film = film;
	}
}
