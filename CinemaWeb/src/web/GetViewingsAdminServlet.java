package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
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
import storage.TheatersViewingsFilmsContainer;
import storage.AddViewingPackage;

/**
 * Servlet implementation class GetViewingsAdminServlet
 */
@WebServlet("/GetViewingsAdmin")
public class GetViewingsAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetViewingsAdminServlet() {
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
			
			List<Viewing> viewings = cinema.getAllViewings();
			List<Theater> theaters = cinema.getAllTheaters();
			List<Film> films = cinema.getFilms("title", true);
			
			// Put all data into a single container object.
			TheatersViewingsFilmsContainer container = new TheatersViewingsFilmsContainer();
			container.setFilms(films);
			container.setViewings(viewings);
			container.setTheaters(theaters);
			
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
		Cinema cinema = new Cinema();
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			// receive JSON string.
			String parameters = request.getReader().lines().collect(Collectors.joining());
			
			// Convert the JSON string.
			Gson gson = new Gson();
			AddViewingPackage info = gson.fromJson(parameters, AddViewingPackage.class);
			
			Cinema cin = new Cinema();
			
			if(info.getMode().equalsIgnoreCase("add"))
				cin.addViewing(0, info.getFilmtitle(), info.getStart(), info.getTheaterId());
			else if(info.getMode().equalsIgnoreCase("remove"))
				cin.removeViewing(info.getId());
			
		} catch (Exception e /*ClassNotFoundException | SQLException e*/) {
			response.getWriter().append("Error: " + e.getMessage());
		}
	}

}
