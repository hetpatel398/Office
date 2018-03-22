<%@page import="abc.VO.dateVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container">
<h2>${msg }</h2>
<h2>Select Date for Recordings</h2>
<%
	List d = (ArrayList)session.getAttribute("d");
	if(d.size() > 0)
	{
%>
<!-- <div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Select Date
    <span class="caret"></span>
    </button>
 -->
 <form action="insertrecord.htm" method="post">
 <div class="form-group">        
 <select class="form-control" name="date">
 <option >Select Date</option>
 <%
	for(int i=0;i<d.size();i++)
	{
		dateVO dateVO = (dateVO)d.get(i);
	
%> 
	<option><%=dateVO.getDates() %></option>

 <%
	}
	}
 
 %>
<!-- </div> -->
</select>
</div>
<br>
<div class="form-group">        
  		<button type="submit" class="btn btn-default" id="btn">Submit</button>      
 	</div>
</form>


<h4><a href="<%=request.getContextPath()%>/indexsadmin.htm">Back</a></h4>


<h4><a href="j_spring_security_logout?${_csrf.parameterName}=${_csrf.token}">Log-Out</a></h4>

</div>

 <script src="js/jquery.js">
</script>
<script src="js/bootstrap.min.js">
</script>

</body>
</html>