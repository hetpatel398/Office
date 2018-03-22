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
<h3>${msg }</h3>
<form action="searchclient.htm" method="post">

Enter Client Code:<input type="text"  name="ccode"/><br>
<input type="submit" value="Search" />
</form>


</div>


 <script src="js/jquery.js">
</script>
<script src="js/bootstrap.min.js">
</script>

</body>
</html>