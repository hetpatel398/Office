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

<%-- <h4><a href="<%=request.getContextPath()%>/super.htm">Generate Report</a></h4>

<h4><a href="<%=request.getContextPath()%>/getrecordings.htm">Get Recordings</a></h4>
 --%>
 
<h4><a href="<%=request.getContextPath()%>/super.htm">Generate Report</a></h4>

<h4><a href="j_spring_security_logout?${_csrf.parameterName}=${_csrf.token}">Log-Out</a></h4>

</div>
<script src="js/jquery.js">
</script>

<script src="js/bootstrap.min.js">
</script>



</body>
</html>