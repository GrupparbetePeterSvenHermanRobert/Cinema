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
 * Servlet implementation class GetFilmsBookingServlet
 */
@WebServlet("/GetFilmsBooking")
public class GetFilmsBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFilmsBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Cinema cinema = new Cinema();
		String s = request.getParameter("id");
		try {
			int index = Integer.parseInt(s);

		List<Film> filmList = cinema.getFilms("title", true);
		request.setAttribute("films", filmList);	
		request.setAttribute("film", filmList.get(index));
		
		RequestDispatcher dist = request.getRequestDispatcher("/WEB-INF/filmbooking.jsp");
		
		if (dist != null)
			dist.forward(request, response);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
