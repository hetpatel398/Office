<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container">
<h2>Upload-Client</h2>
<f:form class="form-horizontal" action="eclient.htm?code=${data.clientCode }&cname=${data.clientCname }" method="post" modelAttribute="data">
  <div class="form-group">
      <label class="control-label col-sm-2" for="name">Client-Name:</label>
      <div class="col-sm-10">
		<f:input path="clientCname" value="${data.clientCname }" disabled="true"  />
		</div>
  </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="code">Client-Code:</label>
      <div class="col-sm-10">
		<f:input path="clientCode"  value="${data.clientCode }" disabled="true" />
		</div>
  </div>
  
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-10">
		<f:input path="clientEmail" value="${data.clientEmail }"/>
		</div>
  </div>
  
    <div class="form-group">
      <label class="control-label col-sm-2" for="phn">Phone-No:</label>
      <div class="col-sm-10">
		<f:input path="clientPhn" value="${data.clientPhn }"  />
		</div>
  </div>
  
    <div class="form-group">
      <label class="control-label col-sm-2" for="file">Confirmation Required:</label>
      <div class="col-sm-10">
		Yes:<f:radiobutton path="clientConfirm" value="Y"/>
		No:<f:radiobutton path="clientConfirm" value="N"/>
<%-- 		<f:input path="clientConfirm" /> --%>
		</div>
  </div>
  <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
  		<button type="submit" class="btn btn-default" id="btn">Submit</button>      
      </div>
   </div>
  
</f:form>

<h4><a href="<%=request.getContextPath()%>/addclient.htm">Back</a></h4>

<h4><a href="j_spring_security_logout?${_csrf.parameterName}=${_csrf.token}">Log-Out</a></h4>


</div>



 <script src="js/jquery.js">
</script>
<script src="js/bootstrap.min.js">
</script>

</body>
</html>