<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.dao.*,com.domain.*,com.controller.*,java.util.*" %>
    


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Reservation信息列表</title>
</head>
<body>
    <h2>所有Reservation信息如下： </h2><br />
    
    
     <form name="forml7" action="/restaurantReservationSystem/servlet/DoDeleteReservationServlet" method="POST">
    <fieldset>
    <legend>请选择你要删除的Reservation</legend>
    
     <table border="2" width="700">
    <tr>
        <th width="100">编号 </th>
        <th width="120">餐桌号</th>
        <th width="160">用餐人数</th>
        <th width="160">用餐日期</th>
        <th width="160">用餐时间</th>
        <th width="160">顾客姓名</th>
        <th width="160">顾客电话</th>
        <th width="160">是否删除</th>
    </tr>
        <%
        BookingSystem bookingSystem = BookingSystem.getInstance();
        ArrayList<Reservation> list = bookingSystem.getReservations();
        
        Iterator<Reservation> reservationIt = list.iterator();
        while(reservationIt.hasNext()) {
            Reservation r = reservationIt.next();
            Customer customer = r.getCustomer();
            int oid = r.getOid();
        %>
        
        <tr>
            <td><%= r.getOid() %>
            <td><%= r.getTable_id() %></td>
            <td><%= r.getCovers() %></td>
            <td><%= r.getDate() %></td>
            <td><%= r.getTime() %></td>
            <td><%= customer.getName() %></td>
            <td><%= customer.getPhonenumber() %></td> 
            <td><input type="radio" name="doDelete" value= <%= oid%>></td>
        </tr>
        <%
        }
        %>
    </table>
    
    <input type="submit" value="确认删除"></fieldset>
    </form>


</body>
</html>
