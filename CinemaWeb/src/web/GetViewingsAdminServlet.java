package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinema.Cinema;
import cinema.Film;
import cinema.Viewing;

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
		int id = Integer.parseInt(request.getParameter("id"));
		Cinema cinema = new Cinema();
		
		try {
			List<Viewing> viewings = cinema.getAllViewings();
			
			request.setAttribute("viewing", viewings.get(id));
			request.setAttribute("viewings", viewings);
			
			Film film = cinema.getFilm(viewings.get(id).getFilmTitle());
			if(film != null)
				request.setAttribute("film", film);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminviewing.jsp");
			
			if(dispatcher != null) {
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			response.getWriter().append("Error: " + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
