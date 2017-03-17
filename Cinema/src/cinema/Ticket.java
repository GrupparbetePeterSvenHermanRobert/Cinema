package cinema;
/**this is the Ticket
 * @author Sven
 * @version 0.1
 */
public class Ticket {

	
/** Ticket ID**/
private String ticketId;

/** viewing **/
private Viewing viewing;

/**the seat number in the theatre**/
private int seat;


public Viewing getViewing() {
	return viewing;
}


public void setViewing(Viewing viewing) {
	this.viewing = viewing;
}


public int getSeat() {
	return seat;
}


public void setSeat(int seat) {
	this.seat = seat;
}


public int getTheatreId() {
	return theatreId;
}


public void setTheatreId(int theatreId) {
	this.theatreId = theatreId;
}


public String getTicketId() {
	return ticketId;
}


int theatreId;


/**the id of the Theatre
 * @param ticketId
 * @param viewing
 * @param seat
 * @param theatreId
 **/
public Ticket( String ticketId,Viewing viewing, int seat, int theatreId ){
	this.ticketId= ticketId;
	this.viewing = viewing;
	this.seat = seat;
	this.theatreId= theatreId;
}
	








}
