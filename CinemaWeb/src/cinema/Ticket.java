package cinema;

/**
 * this is the Ticket
 * 
 * @author Sven
 * @version 0.1
 */
public class Ticket {

	public Ticket(String ticketId, Viewing viewing, int seat, int theaterId) {
		this.ticketId = ticketId;
		this.viewing = viewing;
		this.seat = seat;
		this.theaterId = theaterId;
	}
	/** Ticket ID **/
	private String ticketId;

	/** viewing **/
	private Viewing viewing;

	/** the seat number in the theater **/
	private int seat;
	
	private int theaterId;


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
		return theaterId;
	}


	public void setTheatreId(int theaterId) {
		this.theaterId = theaterId;
	}


	public String getTicketId() {
		return ticketId;
	}


	
	}







