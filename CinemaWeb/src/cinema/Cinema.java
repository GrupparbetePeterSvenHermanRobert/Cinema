package cinema;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
/**this is the Ticket
 * @author Sven
 * @version 0.1
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This filmlist will be a set of films
 * 
 */

public class Cinema {
	private SqlManager sqlManager;

	public Cinema() {
		sqlManager = SqlManager.getSingleton();
	}
	
	public void close() {
		try {
			sqlManager.close();
		} catch (SQLException e) {
			e.printStackTrace();
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
	 * @throws ClassNotFoundException 
	 */
	public void addFilm(String title, int durationInMinutes, String description) throws SQLException, ClassNotFoundException {
		String query = "add_film(" + title + "', '" + description + "', '" + durationInMinutes + "');";
		sqlManager.callStoredProcedure(query);
	}

	public List<Film> getFilms(String orderByColumn, boolean ascending) throws SQLException, ClassNotFoundException {
		String query = "";
		
		if(ascending)
			query = "get_films_order_by_title();";
		else
			query = "get_films_order_by_title_desc();";
		
		
		ArrayList<Map<String, Object>> result = sqlManager.callStoredProcedure(query);
		
		Film newFilm;		
		ArrayList<Film> filmList = new ArrayList<Film>();
		for (Map<String, Object> film : result) {
			newFilm = new Film(film);
			filmList.add(newFilm);
		}

		return filmList;
	}
	
	public List<Film> getFilms(String filter) throws SQLException, ClassNotFoundException {
		String query = "";

		query = "get_films_by_filter(" + filter + ");";
		
		ArrayList<Map<String, Object>> result = sqlManager.callStoredProcedure(query);
		
		Film newFilm;		
		ArrayList<Film> filmList = new ArrayList<Film>();
		for (Map<String, Object> film : result) {
			newFilm = new Film(film);
			filmList.add(newFilm);
		}

		return filmList;
	}

	public Film getFilm(String title) throws ClassNotFoundException, SQLException {
		ArrayList<Map<String, Object>> result = null;
		
		result = sqlManager.callStoredProcedure("get_film_by_title(" + title + ")");
		
		Map<String, Object> filmMap = result.get(0);
		Film film = new Film(filmMap);
		
		return film;
	}

	public List<Viewing> getAllViewings() throws ClassNotFoundException {	
		List<Viewing> viewings = new ArrayList<Viewing>();
		
		try {
			ArrayList<Map<String, Object>> result = sqlManager.callStoredProcedure("get_viewings()");
			Viewing viewing;
			for(Map<String, Object> row : result) {
				int id = (int)row.get("id");
				String filmTitle = (String)row.get("filmTitle");
				int theaterId = (int)row.get("theaterId");
				Timestamp time = (Timestamp)row.get("startTime");
				LocalDateTime startTime = time.toLocalDateTime();
				time = (Timestamp)row.get("endTime");
				LocalDateTime endTime = time.toLocalDateTime();
				
				// TODO Check if the film exists.
				// TODO Add the viewing to the list.
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
