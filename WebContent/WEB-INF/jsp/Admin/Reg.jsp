<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div class="container">
<h2>Register</h2>
	<f:form class="form-horizontal" action="insert.htm" method="post" modelAttribute="reg">
  <div class="form-group">
      <label class="control-label col-sm-2" for="firstname">First-Name:</label>
      <div class="col-sm-10">
    	<f:input class="form-control" path="firstName"/>    
      </div>
  </div>
  <div class="form-group">
   <label class="control-label col-sm-2" for="lastname">Last-Name:</label>
      <div class="col-sm-10">
      	<f:input class="form-control" path="lastName"/>  
      </div>
      
  </div>
  <div class="form-group">
   <label class="control-label col-sm-2" for="username">User-Name:</label>
      <div class="col-sm-10">
  		 <input class="form-control" name="un" type="text" >
  	  </div>
  </div>
  <div class="form-group">
   <label class="control-label col-sm-2" for="password">Password:</label>
      <div class="col-sm-10">
  	 	<input class="form-control" name="pswd" type="password" />
  	 </div>
  </div>
  
  <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Register</button>
      </div>
    </div>

<%-- 		<table align="center">

			<tbody>
				<tr>
					<td>First Name:-</td>
					<td><f:input path="firstName" /></td>
				</tr>

				<tr>
					<td>Last Name:-</td>
					<td><f:input path="lastName" /></td>
				</tr>

				<tr>
					<td>User Name:-</td>
					<td><input type="text" name="un"></td>
				</tr>

				<tr>
					<td>Password:-</td>
					<td><input type="password" name="pswd"></td>
				</tr>

			</tbody>
		</table>

 --%>
		<!-- <input type="submit"> -->
	</f:form>




</div>
</body>
</html>