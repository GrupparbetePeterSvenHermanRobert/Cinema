package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cinema.Cinema;

/**
 * Servlet implementation class AddFilmServlet
 */
@WebServlet("/AddFilm")
public class AddFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String genre = request.getParameter("genre");
		int pgi = Integer.parseInt(request.getParameter("age"));
		int duration = Integer.parseInt(request.getParameter("time"));
		int year = Integer.parseInt(request.getParameter("year"));
		
		Cinema cinema = new Cinema();
		try {
			cinema.addFilm(title, duration, description, genre, year, pgi);
			response.sendRedirect("GetFilmsAdmin?id=0");
		} catch (ClassNotFoundException | SQLException e) {
			response.getWriter().append("Error: " + e.getMessage());
		}
	}

}
