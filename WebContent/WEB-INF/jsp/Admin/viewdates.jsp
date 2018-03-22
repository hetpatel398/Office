<%@page import="abc.VO.RegVO"%>
<%@page import="abc.VO.dateVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<link href="css/bootstrap.min.css" rel="stylesheet">

<body >

<%
List list = (ArrayList)session.getAttribute("dates");


	if(list.size()>0)
	{
		
%>

<div class="container">

<h2>${msg }</h2>
<h2>Table</h2>
<table class="table table-bordered">

<tr>
<td >Dates</td>
<td >Distribute</td>

</tr>

<%
	
System.out.println(list);
int flag=1;
	for(int i=0;i<list.size();i++)
	{
		dateVO dateVO=(dateVO)list.get(i);
		if(dateVO.getDpin().equals("0"))		
		{
			flag=0;
%>	
<tr>
<td><%=dateVO.getDates()%></td>
<td><a href="selectusers.htm?date=<%=dateVO.getDates()%>" >Distribute</a></td>
</tr>	
<%		
		}
	}
%>

</table>
<%
	if(flag == 1)
	{
%>
	<h2>All codes are Distributed</h2>
<% 
	}
	}
%>	

<h3><a href="j_spring_security_logout?${_csrf.parameterName}=${_csrf.token}">Log-Out</a></h3>
<h3><a href="<%=request.getContextPath()%>/admin.htm?msg=">Back</a></h3>

</div>

<script src="js/jquery.js">
</script>

<script src="js/bootstrap.min.js">
</script>


</body>

</html>