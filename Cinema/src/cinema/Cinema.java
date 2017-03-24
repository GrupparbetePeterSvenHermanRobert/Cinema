package cinema;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDateTime;
/**this is the Ticket
 * @author Sven
 * @version 0.1
 */
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This filmlist will be a set of films
 * 
 */

public class Cinema {
	private SqlManager sqlManager;

	public Cinema() {
		sqlManager = SqlManager.getSingleton();
		try {
			sqlManager.Initialize();
		} catch (SQLException e) {
			System.err.print(e.getMessage());
		} finally {
			try {
				sqlManager.close();
			} catch (SQLException e) {
				System.err.print(e.getMessage());
			}
		}
	}

	/**
	 * here makes tickets
	 * 
	 * @param ticketID
	 * @param viewing
	 * @param seat
	 * @param theatreId
	 * @return createTicket
	 */
	public Ticket createTicket(String ticketID, Viewing viewing, int seat, int theatreId) {

		int id = Math.abs(theatreId);
		Ticket createTicket = null;

		if (id < theaterList.size()) {

			// TODO kontrollera att sittplatsen finns
			if (viewing.seatAvailable(seat))
				createTicket = new Ticket(ticketID, viewing, seat, id);
			else
				return null;
		}
		return createTicket;
	}

	/**
	 * 
	 * @param title
	 *            - Filmtitel
	 * @param description
	 *            - Beskrivning av aktuell film
	 * @param durationInMinutes
	 *            - Filmens längd i minuter
	 */
	public void addFilm(String title, int durationInMinutes, String description) {

	}

	/*
	 * 
	 */
	public String getFilms() {
		ArrayList<Map> result = sqlManager.sendQuery("SELECT * FROM films");
	}

	public String getFilm(String title) {
		sqlManager.callStoredProcedure("get_film_by_title(" + title + ")");
	}

	public String getAllViewings() {
		ArrayList<Map> result = sqlManager.sendQuery("SELECT * FROM viewing");
		
	}

	public String getAllTheaters() {
		// SQLManagers
	}

	// public String listViewings(int theatreId) {
	//
	// }

	public boolean addViewing(int id, String filmTitle, String startTime, String endTime, int theaterId) {
		// SQLManager CALL add_viewing(()
		return false;
	}

	public boolean bookSeat(int teatreId, LocalDateTime start, int seatId, int seatCount, String ticketId) {

	}

}
