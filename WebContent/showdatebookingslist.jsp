<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import=" com.dao.*,com.domain.*, java.util.*,javax.servlet.*" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通过日期查找Booking(s)</title>
</head>
<body>


    <form name="forml2" action="/restaurantReservationSystem/servlet/SaveReservationServlet" method="POST">
    <fieldset>
    <legend>请输入Reservation的信息:</legend>
    Covers:<br>
    <input type="text" name="covers" value="10">
    <br>
    Date:<br>
    <input type="text" name="date" value="2018-07-07">
    <br>
    Time:<br>
    <input type="text" name="time" value="18:00:00">
    <br>
    Table_id:<br>
    <input type="text" name="table_id" value="9">
    <br>
    Name:<br>
    <input type="text" name="name" value="Mr J">
    <br>
    PhoneNumber:<br>
    <input type="text" name="phonenumber" value="80080880">
    <br>
    
    <br>
    <input type="submit" value="Submit"></fieldset>
    </form>

<h2>所查询的这一天的Booking情况如下：</h2>

    <table border="2" width="700">
    <tr>
        <th width="120">餐桌号</th>
        <th width="160">用餐人数</th>
        <th width="160">用餐日期</th>
        <th width="160">用餐时间</th>
    </tr>
        <%
        ///暂时去掉黄色警告，回头来修改
        @SuppressWarnings("unchecked")
        ArrayList<AbstractBooking> list = (ArrayList<AbstractBooking>)request.getAttribute("datebookingslist");
          if(list != null){  
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
         } 
        %>
    </table>
    
<h2>这一天空闲的餐桌如下：</h2>

    <table border="2" width="700">
    <tr>
        <th width="120">餐桌号</th>
        <th width="200">餐桌最大容纳人数</th>
    </tr>
        <%
        ///暂时去掉黄色警告，回头来修改
        @SuppressWarnings("unchecked")
        ArrayList<Table> tableList = (ArrayList<Table>)request.getAttribute("unusedTablesList");
        if(tableList != null){
            Iterator<Table> tableIt = tableList.iterator();
            while(tableIt.hasNext()){
                Table unusedTable = tableIt.next(); 
        %>
        <tr>
            <td><%= unusedTable.getNumber() %></td>
            <td><%= unusedTable.getPlaces() %></td>
        </tr>
        <%
            }
        }
        %>
    </table>
    
</body>
</html>