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
  <h2>Login</h2>

	<form  class="form-horizontal" action="j_spring_security_check" name="form" method="post">

  <div class="form-group">
  <label class="control-label col-sm-2" for="username">User-Name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="username" placeholder="Enter User-Name">
      </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="password" >Password:</label>
      <div class="col-sm-10">
      	<input type="password" class="form-control" name="password" placeholder="Enter password">
      </div>
  </div>
  
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Login</button>
      </div>
    </div>
  
		<!-- <table align="center">

			<tbody>

				<tr>
					<td>User Name:-</td>
					<td><input type="text" name="username"></td>
				</tr>

				<tr>
					<td>Password:-</td>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="login" name="login"></td>
				</tr>

			</tbody>
		</table>
 -->

<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

	</form>


<a href="reg.htm">Register Here....!</a>

</div>
</body>
</html>