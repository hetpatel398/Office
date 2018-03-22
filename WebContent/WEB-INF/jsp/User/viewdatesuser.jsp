<%@page import="abc.VO.confirmVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<body>

<div class="container">
<h2>Table</h2>
<table class="table table-bordered">

<tr>
<td >Dates</td>
<td >Show-Pending confirmations</td>

</tr>

<%
	List list =(ArrayList) session.getAttribute("ud");
	String uname=(String) session.getAttribute("uname");
	System.out.println(list);
	
	for(int i=0;i<list.size();i++)
	{
				
%>	
<tr>
<td ><%=((confirmVO)list.get(i)).getTrdate()%></td>
<td ><a href="showcodes.htm?date=<%=((confirmVO)list.get(i)).getTrdate() %>">Show-Pending confirmations</a></td>
</tr>	
<%		
	}
%>



</table>

<h3><a href="j_spring_security_logout?${_csrf.parameterName}=${_csrf.token}">Log-Out</a></h3>
</div>

<script src="js/jquery.js">
</script>

<script src="js/bootstrap.min.js">
</script>

</body>
</html>