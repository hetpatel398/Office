<%@page import="abc.VO.LoginVO"%>
<%@page import="abc.VO.RegVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>

<link href="css/bootstrap.min.css" rel="stylesheet">

<body>
<%
	List users = (ArrayList)session.getAttribute("users");
%>
<div class ="container">
<h2>Date:${date }</h2>
<h2>Provide User availablity</h2> 
<form action="distribute.htm" method="post">
	
	<input type="hidden" name="date" value="${date}">
	<%
		for(int i=0;i<users.size();i++)
		{
			LoginVO loginVO = (LoginVO)users.get(i);
			
	%>
		<div class="checkbox">
		<input type="checkbox" name="users" checked="checked" value="<%=loginVO.getLoginId() %>" id=""/><%=loginVO.getUserName() %><br>
		</div>
	<%
		}
	%>
	
	<div class="form-group">        
        <button type="submit" class="btn btn-default">Submit</button>
    </div>
  
</form>

</div>


<script src="js/jquery.js">
</script>

<script src="js/bootstrap.min.js">
</script>


</body>
</html>