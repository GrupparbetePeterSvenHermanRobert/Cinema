package cinema;

import java.util.SortedSet;

/** This class represents a single theatre within a cinema.
 * @author Gustaf Peter Hultgren
 * @version 0.2 **/
public class Theatre {
	/** The identification number of this theatre. **/
	private int theatreId;
	/** The amount of seat rows within this theatre. **/
	private int seatRows;
	/**  **/
	private int seatColumns;
	/** A set of viewings sorted by time. **/
	private SortedSet<Viewing> viewingList;
	
	
	
}
