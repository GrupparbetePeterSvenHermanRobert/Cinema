package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cinema.Cinema;
import cinema.Film;
import cinema.Theater;
import cinema.Viewing;
import storage.TheaterViewingFilmContainer;
import storage.TheatersViewingsFilmsContainer;

/**
 * Servlet implementation class GetFilmTheaterViewingServlet
 */
@WebServlet("/GetFilmTheaterViewing")
public class GetFilmTheaterViewingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFilmTheaterViewingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cinema cinema = new Cinema();
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json;characterset=UTF-8");
			PrintWriter out = response.getWriter();
			
			Viewing viewing = cinema.getAllViewings();
			Theater theater = cinema.getAllTheaters();
			Film film = cinema.getFilms("title", true);
			
			// Put all data into a single container object.
			TheaterViewingFilmContainer container = new TheaterViewingFilmContainer();
			container.setFilm(film);
			container.setViewing(viewing);
			container.setTheater(theater);
			
			// Convert the container into a JSON string and send to the front end. 
			out.print(new Gson().toJson(container));
			out.flush();
			
		} catch (ClassNotFoundException | SQLException e) {
			response.getWriter().append("Error: " + e.getMessage());
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}