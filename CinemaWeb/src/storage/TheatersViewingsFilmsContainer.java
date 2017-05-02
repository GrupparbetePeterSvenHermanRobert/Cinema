/**
 * 
 */
package storage;

import java.util.List;

import cinema.Film;
import cinema.Theater;
import cinema.Viewing;

/**
 * @author Gustaf Peter Hultgren **/
public class TheatersViewingsFilmsContainer {
	private List<Film> films;
	private List<Viewing> viewings;
	private List<Theater> theaters;
	
	public List<Film> getFilms() {
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}
	public List<Viewing> getViewings() {
		return viewings;
	}
	public void setViewings(List<Viewing> viewings) {
		this.viewings = viewings;
	}
	public List<Theater> getTheaters() {
		return theaters;
	}
	public void setTheaters(List<Theater> theaters) {
		this.theaters = theaters;
	}
}
