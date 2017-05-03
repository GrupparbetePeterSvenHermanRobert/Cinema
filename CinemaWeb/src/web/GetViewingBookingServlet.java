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
 * Servlet implementation class GetViewingBookingServlet
 */
@WebServlet("/GetViewingBooking")
public class GetViewingBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetViewingBookingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cinema cinema= new Cinema();
		String filmtitle = request.getParameter("title");
		System.out.println(filmtitle);
		
		try {
			Film film = cinema.getFilm(filmtitle);
			if (film != null)
				System.out.println("Inte null");
			else
				System.out.println("Film är null");
			List<Viewing> viewings= cinema.getAllViewings();
		
			for (Viewing v : viewings){
				System.out.println(v.getDate() + " : " +v.getTime());
				
			}
			/*request.setAttribute("film",film);
			request.setAttribute("viewings",viewings);
			*/
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		RequestDispatcher dist = request.getRequestDispatcher("/WEB-INF/viewingbooking.jsp");

		if (dist != null)
			dist.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
