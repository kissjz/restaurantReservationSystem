package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoActionServlet
 */
public class DoActionServlet extends HttpServlet {
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
	    String doAction = request.getParameter("doAction");
	    
	    boolean isUpdateTime = doAction.equals("updateTime");
	    //TODO：有必要回头修改，不利于扩展更多的doAction
	    if(isUpdateTime) {
	        response.sendRedirect("../updatetimebookingslist.jsp");
	    }
	    else {
	        response.sendRedirect("../deletereservationbookingslist.jsp");
	    }
	}

}
