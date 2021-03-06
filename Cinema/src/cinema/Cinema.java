package cinema;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
/**this is the Ticket
 * @author Sven
 * @version 0.1
 */
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This filmlist will be a set of films
 * 
 */

public class Cinema {
	public SortedSet<Film> filmList;
	public ArrayList<Theater> theaterList;
	public ArrayList<Ticket> ticketList;

	public Cinema() {
		filmList = new TreeSet<Film>();
		theaterList = new ArrayList<Theater>();
		ticketList = new ArrayList<Ticket>();
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
	public Ticket createTicket (String ticketID,Viewing viewing, int seat, int theatreId){

		int id = Math.abs(theatreId);
		Ticket createTicket = null;

		if (id < theaterList.size()) {

			// TODO kontrolera att sätets finns
			if(viewing.seatAvailable(seat))
				createTicket = new Ticket(ticketID, viewing, seat, id);
			else
				return null;
		}
		return createTicket;
	} 
	
	/**
	 * 
	 * @param title - Filmtitel
	 * @param description - Beskrivning av aktuell film
	 * @param minutes - Filmens längd i minuter
	 */
	public void addFilm(String title, String description, int minutes) {
		Film film = new Film(title, description, minutes);
		filmList.add(film);
	}
	
	/*
	 * 
	 */
	public String getFilms() {
		String films = "";
		for (Film film : filmList) {
			films += film + "\n";
		}
		return films;
	}
	
	public Film getFilm(String title) {
		Film filmToReturn = null;
		for (Film film : filmList) {
			if (title == film.getTitle())
				filmToReturn = film;
		}
		return filmToReturn;
	}

	public String[] listAllViewings() {
		ArrayList<String> allList = new ArrayList<String>();
		for (Theater teater : theaterList) {
			String array[] = teater.getViewings();
			allList.add("Teater: " + teater.getId());
			for (String string : array)
				allList.add(string);
		}
		return allList.toArray(new String[0]);
	}

	public String[] listViewings(int theatreId) {
		int id = Math.abs(theatreId);
		if (id < theaterList.size()) {
			return this.theaterList.get(id).getViewings();
		}
		return null;
	}

	public boolean saveToFile(Path path) {
		FileHandler c = FileHandler.getSingleton();
		try {
			c.save(new String(), path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean loadToFile(Path path) {

		FileHandler c = FileHandler.getSingleton();

		try {
			c.load(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean addViewing(int theaterId, Film film, LocalDateTime start) {
			if (theaterId > 0 || theaterId < theaterList.size()){
				return theaterList.get(theaterId).addViewing(film, start);				
			}
		return false;
	}

	public boolean bookSeat(int theatreID, LocalDateTime start, int seatId, String ticketId){ 
			
			int id = Math.abs(theatreID);
			if (id<theaterList.size()){
				return theaterList.get(id).bookSeat(start, seatId, ticketId);
			}
		
		return false;
	}

	public boolean bookSeat(int teatreId, LocalDateTime start, int seatId, int seatCount,String ticketId) {
		int id = Math.abs(teatreId);
		if (id<theaterList.size()){
			return theaterList.get(id).bookSeat(start, seatId,seatCount,ticketId);
		}
	
	return false;
	}

}

