package servlet;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BookingSystem;

/**
 * Servlet implementation class DoDeleteReservationServlet
 */
public class DoDeleteReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        
        String oid_str = request.getParameter("doDelete");
        int oid = Integer.parseInt(oid_str);
        BookingSystem bookingSystem = BookingSystem.getInstance();//BookingSystem是单件类
        bookingSystem.deleteReservation(oid);
        response.sendRedirect("/restaurantReservationSystem/bookingslist.jsp");
	}

}
