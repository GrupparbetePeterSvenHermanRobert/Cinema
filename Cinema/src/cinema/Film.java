package cinema;

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
	public Film(String title, String description, long length) {
		this.title = title;
		this.description = description;
		this.length = Duration.ofMinutes(length);
		period = LocalDateTime.now().plusMonths(2);
	}
	
	/** Create a new film object from the given information.
	 * @param info -A map where the key is the string name for the column and the object is the data. **/
	public Film(Map<String, Object> info) {
		title = (String)info.get("title");
		description = (String)info.get("description");
		length = Duration.ofMinutes((long)info.get("duration"));
		period = LocalDateTime.now().plusMonths(2);
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
	
	/** Main test function. **/
	public static void main(String[] args) {
		Film film = new Film("Guardians of the Galaxy", "A good movie.", 125);
		System.out.println("Title: " + film.getTitle());
		System.out.println("Description: " + film.getDescription());
		System.out.println("Length: " + film.getLength());
		System.out.println("Period: " + film.getPeriod());
		
		System.out.println("----------------------------------------");
		System.out.println(film.toString());
	}

}
