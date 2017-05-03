package storage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddViewingPackage {
	private String mode;
	private int id;
	private String filmtitle;
	private int theaterId;
	private String description;
	private LocalDate date;
	private LocalDateTime start;
	private LocalDateTime end;
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilmtitle() {
		return filmtitle;
	}
	public void setFilmtitle(String filmtitle) {
		this.filmtitle = filmtitle;
	}
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDateTime getStart() {
		return start;
	}
	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	public LocalDateTime getEnd() {
		return end;
	}
	public void setEnd(LocalDateTime end) {
		this.end = end;
	}
}
