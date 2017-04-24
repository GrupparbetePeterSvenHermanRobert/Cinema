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
import java.util.List;
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

	public Ticket createTicket(String ticketID, Viewing viewing, int seat, int theaterId) throws SQLException {

		Ticket createTicket = null;
		
		if (viewing.seatAvailable(seat))
			createTicket = new Ticket(ticketID, viewing, seat, theaterId);
		else
			return null;
		
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
	 * @throws SQLException 
	 */
	public void addFilm(String title, int durationInMinutes, String description) throws SQLException {
		String query = "add_film(" + title + "', '" + description + "', '" + durationInMinutes + "');";
		sqlManager.callStoredProcedure(query);
	}

	public List<Film> getFilms(String orderByColumn, boolean ascending) throws SQLException {
		String query = "";
		if(orderByColumn.equalsIgnoreCase("title")) {
			if(ascending)
				query = "get_films_order_by_title();";
			else
				query = "get_films_order_by_title_desc();";
		}
		else if(orderByColumn.equalsIgnoreCase("id")) {
				if(ascending)
					query = "get_films_order_by_id();";
				else
					query = "get_films_order_by_id_desc();";
		}
		
		ArrayList<Map<String, Object>> result = sqlManager.callStoredProcedure(query);
		
		Film newFilm;		
		ArrayList<Film> filmList = new ArrayList<Film>();
		for (Map<String, Object> film : result) {
			newFilm = new Film(film);
			filmList.add(newFilm);
		}

		return filmList;
	}

	public Film getFilm(String title) {
		ArrayList<Map<String, Object>> result = null;
		try {
			result = sqlManager.callStoredProcedure("get_film_by_title(" + title + ")");
			
			Map<String, Object> filmMap = result.get(0);
			Film film = new Film(filmMap);
			
			return film;	
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return null;
	}

	public List<Viewing> getAllViewings() {	
		List<Viewing> viewings = new ArrayList<Viewing>();
		
		try {
			ArrayList<Map<String, Object>> result = sqlManager.callStoredProcedure("get_viewings()");
			
			for(Map<String, Object> row : result) {
				viewings.add(new Viewing(row));
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return viewings;
	}

	public String getAllTheaters() {
		try {
			ArrayList<Map<String, Object>> result = sqlManager.sendQuery("SELECT * FROM theater;");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return "";
	}

	// public String listViewings(int theatreId) {
	//
	// }

	public boolean addViewing(int id, String filmTitle, LocalDateTime startTime, int theaterId) {
		// SQLManager CALL add_viewing(()
		return false;
	}

	public boolean bookSeat(int teatreId, LocalDateTime start, int seatId, int seatCount, String ticketId) {
		return false;
	}
}
