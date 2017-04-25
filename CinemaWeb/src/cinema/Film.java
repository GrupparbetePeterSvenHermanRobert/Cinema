package cinema;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Den här är användareinterface
 * 
 * @author Sven
 * @version 0.1
 **/

public class Film implements Comparable<Film> {
	/** Movie title **/
	private String title;
	/** Description of the movie **/
	private String description;
	/** the length of the film **/
	private Duration length;
	/** the period the movie will play in the Cinema and the Theatre **/
	private LocalDateTime period;
	/** Genre of the film. **/
	private String genre;
	/** The release year. **/
	private int year;
	/** The PGI of the year. **/
	private int pgi;

	@Override
	public int compareTo(Film arg0) {
		return 0;
	}

	/**
	 * construktor to the film This
	 * 
	 * @param args
	 *            -
	 * 
	 * @return nothing
	 **/
	public Film(String title, String description, long length, String genre, int year, int pgi) {
		this.title = title;
		this.description = description;
		this.length = Duration.ofMinutes(length);
		period = LocalDateTime.now().plusMonths(2);
		this.setGenre(genre);
		this.setYear(year);
		this.setPgi(pgi);
	}
	
	/** Create a new film object from the given information.
	 * @param info -A map where the key is the string name for the column and the object is the data. **/
	public Film(Map<String, Object> info) {
		title = (String)info.get("title");
		description = (String)info.get("description");
		length = Duration.ofMinutes((long)info.get("duration"));
		period = LocalDateTime.now().plusMonths(2);
		setGenre((String)info.get("genre"));
		Date date = (Date)info.get("release_year");
		
		setYear(date.toLocalDate().getYear());
		
		setPgi((int)info.get("pgi"));
	}
	
	/** Create a new film object.
	 * @param title -The title of the film.
	 * @param description -A bief description of the film.
	 * @param length -The length of the film, in minutes.
	 * @param period -The planned period during which this film will be shown. **/
	public Film(String title, String description, long length, LocalDateTime period) {
		this.title = title;
		this.description = description;
		this.length = Duration.ofMinutes(length);
		this.period = period;
	}

	/**
	 * getTitle gets the title
	 * 
	 * @return title
	 **/
	public String getTitle() {
		return title;
	}

	/**
	 * getPeriod
	 * 
	 * @return period
	 **/
	public LocalDateTime getPeriod() {
		return period;
	}

	/**
	 * setPeriod sets the period variable
	 * 
	 * @param period
	 */
	public void setPeriod(LocalDateTime period) {
		this.period = period;
	}

	/**
	 * getDescription will get the Description
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * getLenght will get the Description
	 * 
	 * @return length
	 */
	public long getLength() {
		return length.toMinutes();
	}
	
	@Override
	public String toString() {
		return ("Titel: " + title + "\n" + "Description: " + description + "\n" + "Length in minutes: " + length.toMinutes());
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPgi() {
		return pgi;
	}

	public void setPgi(int pgi) {
		this.pgi = pgi;
	}
	
	/** Main test function. **/
	public static void main(String[] args) {
	}

}
