<%@page import="abc.VO.confirmVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
 <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<body>

<div class="container">
<c:set var="i" value="${msg }"></c:set>
<h2>${i }</h2>

<%
List yconfirm = (ArrayList)session.getAttribute("yconfirm");
List ncomfirm = (ArrayList)session.getAttribute("nconfirm");
List nreply = (ArrayList)session.getAttribute("nreply");
List confirm = (ArrayList)session.getAttribute("confirm");
List cconfirm = (ArrayList)session.getAttribute("cconfirm");

	
	System.out.println(confirm.size() +" "+ ncomfirm.size() +" "+ nreply.size() + " "+yconfirm.size()+" " +cconfirm.size()  );
	if(confirm.size()>0 | ncomfirm.size()>0 | nreply.size()>0 | yconfirm.size()>0 | cconfirm.size()>0)
	{
%>

<h3>Confirm-Codes:Black</h3>
<h3>Not-Confirm-Codes:Red</h3>
<h3>No-Reply-Codes:Green</h3>
<h3>Yet-To-Be-Confirm-Codes:Blue</h3>
<h3>Confirmation not given due to client concern:YellowGreen</h3>

<h3>Table</h3>

<table class="table table-bordered">
<tr>
<td >Code</td>
<td >Comment</td>

</tr>

<%
	String uname=(String) session.getAttribute("uname");

	System.out.println();
	
	for(int i=0;i<ncomfirm.size();i++)
	{
		confirmVO confirmVO = ((confirmVO)ncomfirm.get(i));
		String s=confirmVO.getComment();
		//System.out.println(confirmVO.getCcode());
%>
<tr>
<td style="color:red;"><%=confirmVO.getCcode()%></td>
<td ><%=s%></td>

</tr>	

<%
	}
	
%>
<%
	for(int i=0;i<nreply.size();i++)
	{
		confirmVO confirmVO = ((confirmVO)nreply.get(i));
		String s=confirmVO.getComment();
%>
<tr>
<td  style="color:green;"><%=confirmVO.getCcode()%></td>
<td ><%=s%></td>

</tr>	

<%
	}
	
	for(int i=0;i<yconfirm.size();i++)
	{
		confirmVO confirmVO = ((confirmVO)yconfirm.get(i));
		String s=confirmVO.getComment();
%>
<tr>
<td style="color: blue;"><%=confirmVO.getCcode()%></td>
<td style="color: blue;"><%=s%></td>

</tr>	

<%
	}

	for(int i=0;i<cconfirm.size();i++)
	{
		confirmVO confirmVO = ((confirmVO)cconfirm.get(i));
		//System.out.println(confirmVO.getCcode());
		String s=confirmVO.getComment();
%>
<tr>
<td style="color: #9ACD32;" ><%=confirmVO.getCcode()%></td>
<td><%=s %></td>
</tr>	

<%
	}
	for(int i=0;i<confirm.size();i++)
	{
		confirmVO confirmVO = ((confirmVO)confirm.get(i));
		String s=confirmVO.getComment();
%>

<tr>
<td  ><%=confirmVO.getCcode()%></td>
<td><%=s %></td>
</tr>	
	
<% 
	}
	
	}
%>

</table>
<h3><a href="j_spring_security_logout?${_csrf.parameterName}=${_csrf.token}">Log-Out</a></h3>
<h3><a href="<%=request.getContextPath()%>/super.htm">Back</a></h3>
</div>

<script src="js/jquery.js">
</script>

<script src="js/bootstrap.min.js">
</script>

</body>
</html>