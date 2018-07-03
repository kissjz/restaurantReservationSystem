package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BookingSystem;
import com.domain.WalkIn;

/**
 * Servlet implementation class SaveWalkInServlet
 */
public class SaveWalkInServlet extends HttpServlet {
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
        
        String covers_str = request.getParameter("covers");
        int covers = Integer.parseInt(covers_str);
        String date_str = request.getParameter("date");
        Date date = Date.valueOf(date_str);
        String time_str = request.getParameter("time");
        Time time = Time.valueOf(time_str);
        String table_id_str = request.getParameter("table_id");
        int table_id = Integer.parseInt(table_id_str);
        
        WalkIn walkIn = new WalkIn(covers, date);
        walkIn.setArrivalTime(time);
        walkIn.setTable_id(table_id);
        
        BookingSystem bookingSystem = BookingSystem.getInstance();//BookingSystem是单件类
        bookingSystem.makeWalkIn(walkIn);
        response.sendRedirect("../bookingslist.jsp");
	}

}
