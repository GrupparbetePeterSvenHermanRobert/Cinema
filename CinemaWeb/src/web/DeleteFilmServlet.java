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
 * Servlet implementation class DeleteFilmServlet
 */
@WebServlet("/DeleteFilm")
public class DeleteFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFilmServlet() {
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
		Cinema cinema = new Cinema();

		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		try {
			cinema.deleteFilm(title);
			response.sendRedirect("GetFilmsAdmin?id=0");
		} catch (ClassNotFoundException | SQLException e) {
			response.getWriter().append("Error: " + e.getMessage());
		}
	}

}
