package cinema;

import java.time.LocalDateTime;
import java.util.SortedSet;

/** This class represents a single theater within a cinema.
 * @author Gustaf Peter Hultgren
 * @version 0.2 **/
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
	}
	
	/** Create a new theater.
	 * @param data -An array of the data required to create a new theater. **/
	public Theater(String[] data) {
		// TODO process the data and create the object.
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
	
	public boolean addViewing(Film film, LocalDateTime start) {
		return true;
	}
	
	public Viewing getViewing(Film film, LocalDateTime start) {
		return null;
	}
	
	public String[] getViewings() {
		return null;
	}
	
	public String[] dataToString() {
		return null;
	}
}
