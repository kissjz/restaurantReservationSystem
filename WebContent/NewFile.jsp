<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.dao.*,com.domain.*,com.controller.*,java.util.*" %>
    


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">  
<tr>  
<th><input type="checkbox" onclick="swapCheck()" /></th>  
<th>Month</th>  
<th>Savings</th>  
</tr>  
<tr>  
<td><input type="checkbox" /></td>  
<td>January</td>  
<td>$100</td>  
</tr>  
<tr>  
<td><input type="checkbox" /></td>  
<td>February</td>  
<td>$150</td>  
</tr>  
</table> 

<br>

<table border="1px" width="100%" align="center">
<tr>
<td>爱好:</td>
<td>
<input type="checkbox" name="旅游" value="1" />旅游
<input type="checkbox" name="读书" value="1" />符数
<input type="checkbox" name="体育" value="1" />体育
<input type="checkbox" name="音乐" value="1" />音乐
</td>
</tr>
</table>

</body>
</html>