package cinema;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/** This class represents a single theater within a cinema.
 * @author Gustaf Peter Hultgren
 * @version 0.6 **/
public class Theater {
	/** The identification number of this theater. **/
	private int theaterId;
	/** The amount of seat rows within this theater. **/
	private int seatRows;
	/** The amounts of seat columns within this theater. **/
	private int seatColumns;
	/** A set of viewings sorted by time. **/
	private SortedSet<Viewing> viewingList;
	
	/** Create a new theater.
	 * @param theaterId -The ID number of this theater.
	 * @param seatRows -The amount of seat rows.
	 * @param seatColumns -The amount of seat columns. **/
	public Theater(int theaterId, int seatRows, int seatColumns) {
		this.seatRows = seatRows;
		this.seatColumns = seatColumns;
		this.theaterId = theaterId;
		viewingList = new TreeSet<Viewing>();
	}
	
	/** Create a new theater.
	 * @param data -An array of the data required to create a new theater. 
	 * @throws IOException **/
	public Theater(String data) throws IOException {
		viewingList = new TreeSet<Viewing>();
		int index = data.indexOf(':');
		
		if(index < 0)
			throw new IOException("Invalid data!");
		
		// Remove the theater heading
		String substring = data.substring(index + 1);
		
		// Extract the information from the string.
		String parameters[] = substring.split(",");
		
		if(parameters.length < 3)
			throw new IOException("Invalid data!");
		
		try {
			theaterId = Integer.parseInt(parameters[0]);
			seatRows = Integer.parseInt(parameters[1]);
			seatColumns = Integer.parseInt(parameters[2]);
		}
		catch (NumberFormatException e) {
			throw new NumberFormatException("Teater parameters are invalid! " + e.getMessage());
		}
	}
	
	/** Get the theater ID.
	 * @return The identification number for this theater. **/
	public int getId() {
		return theaterId;
	}
	
	/** Get the amount of seat rows available.
	 * @return The amount of seat rows.**/
	public int getSeatRows() {
		return seatRows;
	}
	
	/** Get the amount of seat columns available.
	 * @return The amount of seat columns.**/
	public int getSeatColumns() {
		return seatColumns;
	}
	
	/** Add a new viewing to the theater.
	 * @param film -The film being displayed.
	 * @param start -The start time for this viewing.
	 * @return True if successful, false if the time is occupied. **/
	public boolean addViewing(Film film, LocalDateTime start) {
		return viewingList.add(new Viewing(film, start, seatRows * seatColumns));
	}
	
	/** Add a new viewing to the theater.
	 * @param film -The film being displayed.
	 * @param start -The start time for this viewing.
	 * @param seatData -The data for the seat bookings.
	 * @return True if successful, false if the time is occupied. **/
	public boolean addViewing(Film film, LocalDateTime start, String seatData) {
		return viewingList.add(new Viewing(film, start, seatRows * seatColumns));
	}
	
	/** Get the selected viewing if it exists.
	 * @param film -The film being displayed.
	 * @param start -The start time for this viewing.
	 * @return The desired viewing or null if it was not found. **/
	public Viewing getViewing(Film film, LocalDateTime start) {
		Viewing viewing = new Viewing(film, start, 1); // Create a new viewing as a search object.
		
		for(Viewing view : viewingList) {
			if(view.compareTo(viewing) == 0)
				return view;
		}
		
		return null;
	}
	
	/** Get a string array representing the viewings in a readable format.
	 * @return An array string where each element represents a single viewing.  **/
	public String[] getViewings() {
		ArrayList<String> viewings = new ArrayList<String>();
		
		for(Viewing view : viewingList)
			viewings.add(view.toString());
		
		return viewings.toArray(new String[0]);
	}
	
	/** Get a string representation of this theater.
	 * @return A string array where the first element represents the theater and the following elements represents
	 * the individual viewing. **/
	public String[] dataToString() {
		ArrayList<String> strings = new ArrayList<String>();
		String theaterString = "theater:" + getId() + "," + getSeatRows() + "," + getSeatColumns();
		strings.add(theaterString);
		
		// Add all 
		for(Viewing view : viewingList)
			strings.add(view.toFileString());
		
		return strings.toArray(new String[0]);
	}
	
	/** Book a seat for a specific viewing.
	 * @param start -The start time of the viewing.
	 * @param seatId -The seat number.
	 * @param ticketId -The ID of the ticket. 
	 * @return True if the seat was available, else false.**/
	public boolean bookSeat(LocalDateTime start, int seatId, String ticketId) {
		Viewing viewing = new Viewing(null, start, seatRows * seatColumns);
		
		for(Viewing view : viewingList) {
			if(view.compareTo(viewing) == 0)
				return view.bookSeat(seatId, ticketId);
		}
		
		return false;
	}
	
	/** Book a seat for a specific viewing.
	 * @param start -The start time of the viewing.
	 * @param seatId -The seat number.
	 * @param seatCount -The amount of adjacent seats wanted.
	 * @param ticketId -The ID of the ticket. 
	 * @return True if the seat was available, else false.**/
	public boolean bookSeat(LocalDateTime start, int seatId, int seatCount, String ticketId) {
		Viewing viewing = new Viewing(null, start, seatRows * seatColumns);
		
		for(Viewing view : viewingList) {
			if(view.compareTo(viewing) == 0)
				return view.bookSeats(seatId, ticketId, seatCount);
		}
		
		return false;
	}
	
	/** Main function for testing the theater class. **/
	public static void main(String[] args) {
		Theater theater = new Theater(0, 3, 4);
		
		boolean check = theater.addViewing(new Film("Lord of the Rings", "A good movie.", Duration.ofMinutes(125)), LocalDateTime.now());
		System.out.println("Add a viewing with no collisions: " + check);
		check = theater.addViewing(new Film("Lord of the Rings", "A good movie.", Duration.ofMinutes(125)), LocalDateTime.now().plusMinutes(50));
		System.out.println("Add a viewing that collides: " + check);
		check = theater.addViewing(new Film("Lord of the Rings", "A good movie.", Duration.ofMinutes(125)), LocalDateTime.now().plusMinutes(150));
		System.out.println("Add a viewing with no collisions: " + check);
		
		
	}
}
