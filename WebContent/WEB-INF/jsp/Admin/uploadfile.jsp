<%@page import="abc.VO.dateVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File upload </title>
</head>
<body >
<div class="container">
<h2>Table</h2>
<table class="table table-bordered">
<%
List dates = (ArrayList)session.getAttribute("date");
	if(dates.size()>0)
	{
		
%>
<tr>
	<td>Dates.</td>
	<td>Names of Exchanges for which File is uploaded.</td>
	<td>No. of Rows in file.</td>
	<td>Delete</td>
</tr>

<tr>
<%
	//List s = (ArrayList)session.getAttribute("ex");
	String a="";
	for(int i=dates.size()-1;i>=0;i--)
	{
		
		if((i+9)<= dates.size())
			break;
		dateVO dateVO =(dateVO)dates.get(i);
		
		//a="";
		/* for(int j=0;j<s.size();j++)
		{
			if(dateVO.getDate().equals(((dateVO)s.get(j)).getDate()))
			{
				System.out.println();
				if(((dateVO)s.get(j)).getExchange().equals("nse"))
					a=a+"NSE ";
				if(((dateVO)s.get(j)).getExchange().equals("bse"))
				{
					//System.out.println(a);
					a=a+"BSE ";
				}
				if(((dateVO)s.get(j)).getExchange().equals("nsefo"))
				{
					System.out.println(a);
					a=a+"NSE-FO ";
				}
			
		
			}
		} */
	
		//System.out.println(dateVO.getDates());	
			
%>

<td><%=dateVO.getDates() %></td>
<td><%=dateVO.getExchange().toUpperCase()%></td>
<td><%=dateVO.getRows() %></td>
<td><a href="deletefile.htm?dateid=<%=dateVO.getDateId()%>">Delete</a></td>
</tr>

<%
	}
}
%>
</table>


<h4>${msg }</h4>

<h4><a href="<%=request.getContextPath()%>/addclient.htm">Add Client Details</a></h4>

<h4><a href="<%=request.getContextPath()%>/uploadnse.htm?msg=">Upload NSE File</a></h4>

<h4><a href="<%=request.getContextPath()%>/uploadbse.htm?msg=">Upload BSE File</a></h4>

<h4><a href="<%=request.getContextPath()%>/uploadnsefo.htm?msg=">Upload NSEFO File</a></h4>

<h4><a href="<%=request.getContextPath()%>/viewdates.htm?msg=1">Distribute Codes </a></h4>

<h4><a href="uploadclient.htm">Client-File</a></h4>

<h4><a href="j_spring_security_logout?${_csrf.parameterName}=${_csrf.token}">Log-Out</a></h4>

</div>
<script src="js/jquery.js">
</script>

<script src="js/bootstrap.min.js">
</script>


</body>

</html>