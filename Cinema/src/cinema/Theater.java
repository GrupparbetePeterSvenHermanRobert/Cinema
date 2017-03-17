package cinema;

import java.util.SortedSet;

/** This class represents a single theater within a cinema.
 * @author Gustaf Peter Hultgren
 * @version 0.2 **/
public class Theater {
	/** The identification number of this theater. **/
	private int theatreId;
	/** The amount of seat rows within this theater. **/
	private int seatRows;
	/** The amounts of seat columns within this theater. **/
	private int seatColumns;
	/** A set of viewings sorted by time. **/
	private SortedSet<Viewing> viewingList;
	
	
	
}
