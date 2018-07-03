package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Restaurant;
import com.domain.AbstractBooking;
import com.domain.Table;

/**
 * Servlet implementation class FindBookingsByDateServlet
 */
public class FindBookingsByDateServlet extends HttpServlet {
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
        
        String date_str  = request.getParameter("date");
        Date date = Date.valueOf(date_str);
        
        String booking = request.getParameter("booking");
        
        
        Restaurant restaurant = new Restaurant();
        ArrayList<AbstractBooking> bookingsList = new ArrayList<AbstractBooking>();
        ArrayList<AbstractBooking> list = restaurant.getBookings();
        ArrayList<Table> tablesList = new ArrayList<Table>();
        
        int[] usedTable = new int[15];
        Arrays.fill(usedTable, 0);//标记11张Table(餐桌)为尚未被使用
        
        Iterator<AbstractBooking> abstractBookingIt = list.iterator();
        while(abstractBookingIt.hasNext()) {
            AbstractBooking ab = abstractBookingIt.next();
            if(ab.getDate().equals(date)) {
                bookingsList.add(ab);
                usedTable[ab.getTable_id()] = 1;//标记该餐桌为使用了
            }
        }
        
        for(int i = 1; i <= 11; i++) {
            if(usedTable[i]==0) {
                tablesList.add(restaurant.getTable(i));//空闲的餐桌集合
            }
        }
        
        request.setAttribute("datebookingslist", bookingsList);
        request.setAttribute("unusedTablesList", tablesList);
        
        //判断booking的类型
        boolean isReservation = booking.equals("reservation");
        if(isReservation) {
            request.getRequestDispatcher("../showdatebookingslist.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("../showdatebookingslist2.jsp").forward(request, response);
        }
        
	}

}
