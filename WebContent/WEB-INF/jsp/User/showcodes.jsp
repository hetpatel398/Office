<%@page import="abc.VO.confirmVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
 <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head><link href="css/bootstrap.min.css" rel="stylesheet">
<body>

<div class="container">
<c:set var="i" value="${msg }"></c:set>
<h2>${i }</h2>

<%
List confirm = (ArrayList)session.getAttribute("confirm");
List ncomfirm = (ArrayList)session.getAttribute("nconfirm");
List nreply = (ArrayList)session.getAttribute("nreply");
String username=(String)session.getAttribute("uname");
	
	System.out.println(confirm.size() +" "+ ncomfirm.size() +" "+ nreply.size());
	if(confirm.size()>0 | ncomfirm.size()>0 | nreply.size()>0)
	{
%>

<h2>Table</h2>

<table class="table table-bordered">
<tr>
<td class="col-md-3 col-sm-3 ">Code</td>
<td class="col-md-3 col-sm-3">Show-Trades</td>
<td class="col-md-3 col-sm-3 ">No-reply/Not-confirm Comments</td>

<td class="col-md-3 col-sm-3">Code Confirmation Not Required.</td>


</tr>

<%
	String uname=(String) session.getAttribute("uname");
	
	System.out.println();
	
	for(int i=0;i<ncomfirm.size();i++)
	{
		confirmVO confirmVO = ((confirmVO)ncomfirm.get(i));
		String s = confirmVO.getComment();
		
		if(confirmVO.getClientconfirm().equals("Y"))
		{	
		
%>
<tr>
<td style="color:red;"><%=confirmVO.getCcode()%></td>
<td ><a href="showtrades.htm?date=<%=confirmVO.getTrdate() %>&code=<%=confirmVO.getCcode()%>&uname=<%=uname%>">Show-Trades</a></td>
<td><%=s %></td>
<td></td>
</tr>	

<%		}
		else if(confirmVO.getClientconfirm().equals("N"))
		{
%>
<tr>
<td style="color:blue;"><%=confirmVO.getCcode()%></td>
<td ><!--  <a href="showtrades.htm?date=<%=confirmVO.getTrdate() %>&code=<%=confirmVO.getCcode()%>&uname=<%=uname%>">-->Show-Trades<!-- </a> --></td>
<td><%=s %></td>
<td ><%-- <a href="confirm.htm?date=<%=confirmVO.getTrdate() %>&code=<%=confirmVO.getCcode()%>&flag=4">OKAY</a> --%>
<form action="confirm.htm" method="post">

<input type="hidden" name="date" value="<%=confirmVO.getTrdate() %>"/>
<input type="hidden" name="code" value="<%=confirmVO.getCcode() %>"/>
<input type="hidden" name="select" value="4" />
<input type="hidden" name="comment" value="" />
<button type="submit" class="btn btn-default">OKAY</button>
</form>

</td>
</tr>	
<% 
			
		}
		else
		{
%>
<tr>
<td ><%=confirmVO.getCcode()%></td>
<td >Code Not Available</td>
<td><%="No comment" %></td>
<td></td>
</tr>	

<% 
		}
	}
	
%>
<%
	for(int i=0;i<nreply.size();i++)
	{
		confirmVO confirmVO = ((confirmVO)nreply.get(i));
		String s = confirmVO.getComment();
		if(s.charAt(s.length()-1) == ',')
			s=s.substring(1,s.length()-1);
		else if(s.length() > 1)
			s=s.substring(1);
	 	
		if(confirmVO.getClientconfirm().equals("Y"))
		{
%>
<tr>
<td style="color:green;"><%=confirmVO.getCcode()%></td>
<td ><a href="showtrades.htm?date=<%=confirmVO.getTrdate() %>&code=<%=confirmVO.getCcode()%>&uname=<%=uname%>" >Show-Trades</a></td>
<td><%=s %></td>

<td></td>
</tr>	

<%
		}
		else if(confirmVO.getClientconfirm().equals("N"))
		{
%>
<tr>
<td style="color:blue;"><%=confirmVO.getCcode()%></td>
<td ><!--  <a href="showtrades.htm?date=<%=confirmVO.getTrdate() %>&code=<%=confirmVO.getCcode()%>&uname=<%=uname%>">-->Show-Trades<!-- </a> --></td>

<td><%=s %></td>
<td ><%-- <a href="confirm.htm?date=<%=confirmVO.getTrdate() %>&code=<%=confirmVO.getCcode()%>&flag=4">OKAY</a> --%>
<form action="confirm.htm" method="post">

<input type="hidden" name="date" value="<%=confirmVO.getTrdate() %>"/>
<input type="hidden" name="code" value="<%=confirmVO.getCcode() %>"/>
<input type="hidden" name="select" value="4" />
<input type="hidden" name="comment" value="" />

<button type="submit" class="btn btn-default">OKAY</button>
</form>

</td>
</tr>	
	
<% 
		}
		else
		{
%>
<tr>
<td ><%=confirmVO.getCcode()%></td>
<td >Code Not Available</td>
<td><%="No comment" %></td>

<td></td>
</tr>	

<%			
		}
	}
	
%>


<%	
	for(int i=0;i<confirm.size();i++)
	{
		confirmVO confirmVO = ((confirmVO)confirm.get(i));
		String s = confirmVO.getComment();
		
		if(confirmVO.getClientconfirm().equals("Y"))
		{
			
		
%>
<tr>
<td  style="color:black;"><%=confirmVO.getCcode()%></td>
<td ><a href="showtrades.htm?date=<%=confirmVO.getTrdate() %>&code=<%=confirmVO.getCcode()%>&uname=<%=uname%>">Show-Trades</a></td>
<td><%=s %></td>
<td></td>
</tr>	

<%
		}
		else if(confirmVO.getClientconfirm().equals("N"))
		{
%>
<tr>
<td style="color:blue;"><%=confirmVO.getCcode()%></td>
<td ><a href="showtrades.htm?date=<%=confirmVO.getTrdate() %>&code=<%=confirmVO.getCcode()%>&uname=<%=uname%>">Show-Trades</a></td>
<td><%=s %></td>
<td ><%-- <a href="confirm.htm?date=<%=confirmVO.getTrdate() %>&code=<%=confirmVO.getCcode()%>&flag=4">OKAY</a> --%>
<form action="confirm.htm" method="post">

<input type="hidden" name="date" value="<%=confirmVO.getTrdate() %>"/>
<input type="hidden" name="code" value="<%=confirmVO.getCcode() %>"/>
<input type="hidden" name="select" value="4" />
<input type="hidden" name="comment" value="" />
<button type="submit" class="btn btn-default">OKAY</button>
</form>


</td>
</tr>	

<%			
		}
		else
		{
%>

<tr>
<td ><%=confirmVO.getCcode()%></td>
<td >Code Not Available</td>
<td><%="No comment" %></td>

<td></td>
</tr>	

<% 
		}
	}
	}
%>

</table>
<h3><a href="j_spring_security_logout?${_csrf.parameterName}=${_csrf.token}">Log-Out</a></h3>
<h3><a href="<%=request.getContextPath()%>/user.htm?username=<%=username%>">Back</a></h3>
</div>

<script src="js/jquery.js">
</script>

<script src="js/bootstrap.min.js">
</script>

</body>
</html>