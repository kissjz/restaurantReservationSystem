package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BookingSystem;
import com.domain.Customer;
import com.domain.Reservation;

/**
 * Servlet implementation class SaveReservationServlet
 */
public class SaveReservationServlet extends HttpServlet {
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
        String name = request.getParameter("name");
        String phonenumber = request.getParameter("phonenumber");
        
        Customer customer = new Customer();
        customer.setName(name);
        customer.setPhonenumber(phonenumber);
        
        Reservation reservation = new Reservation(covers, date, customer);
        reservation.setTime(time);//设置预约要到达的具体时间,并非是实际到达的时间arrival_time
        reservation.setTable_id(table_id);

        
        BookingSystem bookingSystem = BookingSystem.getInstance();//BookingSystem是单件类
        bookingSystem.makeReservation(reservation);
        response.sendRedirect("/restaurantReservationSystem/bookingslist.jsp");
        
	}
	

}
