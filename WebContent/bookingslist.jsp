<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.dao.*,com.domain.*,com.controller.*,java.util.*" %>
    


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Booking信息列表</title>
</head>
<body>
    <h2>所有Booking信息如下： </h2><br />
    <form name="forml5" action="/restaurantReservationSystem/servlet/FindBookingsByDateServlet" method="POST">
    <fieldset>
    <legend>请输入查询的日期:</legend>
    Date:<br>
    <input type="text" name="date" value="2018-07-07">
    <br>
    
    <input type="radio" name="booking" value="reservation" checked>电话预约的客户
    <br>
    <input type="radio" name="booking" value="walkIn">随机走进店里的客户
    
    <input type="submit" value="Submit"></fieldset>
    </form>
    
    <table border="2" width="700">
    <tr>
        <th width="120">餐桌号</th>
        <th width="160">用餐人数</th>
        <th width="160">用餐日期</th>
        <th width="160">用餐时间</th>
    </tr>
        <%
        BookingSystem bookingSystem = BookingSystem.getInstance();
        ArrayList<AbstractBooking> list = bookingSystem.getBookings();
        
        Iterator<AbstractBooking> abstractBookingIt = list.iterator();
        while(abstractBookingIt.hasNext()) {
            AbstractBooking ab = abstractBookingIt.next();
        %>
        <tr>
            <td><%= ab.getTable_id() %></td>
            <td><%= ab.getCovers() %></td>
            <td><%= ab.getDate() %></td>
            <td><%= ab.getTime() %></td>
        </tr>
        <%
        }
        %>
    
    </table>

    <h2>更多操作： </h2><br />
    <form name="forml4" action="/restaurantReservationSystem/servlet/DoActionServlet" method="POST">
    <fieldset>
    <legend>请选择你要执行的操作:</legend>
    <br>
    
    <input type="radio" name="doAction" value="updateTime" checked>更新Reservation到达的时间
    <br>
    <input type="radio" name="doAction" value="deleteReservation">取消已有的Reservation
    
    <input type="submit" value="Submit"></fieldset>
    </form>

</body>
</html>
