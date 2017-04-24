package cinema;

import java.time.LocalDateTime;
import java.util.Map;



/**
 * @author Herman
 *
 */
public class Viewing implements Comparable<Viewing> {
	private Film film;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private int id;
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
	public Viewing(Film film, LocalDateTime startTime, int seatAmount, int id) {
		this.setFilm(film);
		this.setStartTime(startTime);
		setEndTime(startTime.plusMinutes(film.getLength()));
		seats = new String[seatAmount];
		this.id = id;
	}
	
	//En kommentar...

	/**
	 * Overloaded constructor adapted for loading Strings from file. ish
	 */
	public Viewing(Film film, LocalDateTime startTime, String[] seats, int id) {
		this.setFilm(film);
		this.setStartTime(startTime);
		setEndTime(startTime.plusMinutes(film.getLength()));
		this.seats = new String[seats.length];

		for (int i = 0; i < seats.length; i++) {
			this.seats[i] = seats[i];
		}
		
		this.id = id;
	}
	
	public Viewing

	public boolean bookSeat(int seat, String ticketID) {
		boolean success = false;
		if (seats[seat] == null) {
			seats[seat] = ticketID;
			success = true;
		} else {
			success = false;
		}
		return success;
	}

	public boolean bookSeats(int seat, String ticketID, int seatCount, int rowLength) {
		
		int rowSeat = seat % rowLength;
		if(rowSeat + seatCount < rowLength) {
			for(int i = seat; i < seat + seatCount; i++)
				if(seats[seat] != null)
					return false;
			for(int i = seat; i < seat + seatCount; i++)
				seats[seat] = ticketID;
			
			return true;
		}
		
		return false;
	}
	
	/** Get an array with the status of each seat.
	 * @return A string array where each element represents the seat's status. Null = available. **/
	String[] getSeatStatus() {
		return seats;
	}
	
	/** Get the ID of this viewing. **/
	public int getId() {
		return id;
	}
	
	/** Check weather a given seat is available.
	 * @param index -The seat number.
	 * @return True if the seat is available, else False. **/
	boolean seatAvailable(int index) {
		if(index >= 0 && index < seats.length) {
			if(seats[index] == null)
			return true;
		}
		
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
		if (getEndTime().isBefore(o.getStartTime()))
			result = -1;
		else if (getStartTime().isAfter(o.getEndTime())) {
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

	/** Update the seats with the given info.
	 * @param info -A map where the key is the string name for the column. **/
	public void updateSeats(Map<String, Object> info) {
		// TODO Update the seats
	}
	
	@Override
	public String toString() {
		return "Viewing ID: " + id + "\n" + "Title: " + film.getTitle() + "\n" + "Start Time: " + startTime.toString() + "\n" + "End Time: " + endTime.toString();
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
	
	/** Main function for testing this class. **/
	public static void main(String[] args) {
		Film film = new Film("Some Film Title", "Some Film Description", 120);
		Viewing viewing = new Viewing(film, LocalDateTime.now().plusDays(5), 3 * 4, 0);
		
		System.out.println(viewing.bookSeat(0, "Some ID"));
	}
}