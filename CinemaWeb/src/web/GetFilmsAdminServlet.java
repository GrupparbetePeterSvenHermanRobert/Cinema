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

/**
 * Servlet implementation class GetFilmsAdminServlet
 */
@WebServlet("/GetFilmsAdmin")
public class GetFilmsAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFilmsAdminServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cinema cinema = new Cinema();
		
		try {
			List<Film> films = cinema.getFilms("title", true);
			request.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(request.getParameter("id"));
			
			request.setAttribute("films", films);
			request.setAttribute("film", films.get(id));

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminfilm.jsp");
			if(dispatcher != null)
				dispatcher.forward(request, response);
			
		} catch (SQLException | ClassNotFoundException e) {
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
