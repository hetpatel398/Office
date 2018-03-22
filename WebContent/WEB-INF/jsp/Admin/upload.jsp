<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="e" %>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="s" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>

function fn()
{
	var	date=document.getElementById("date");
	var span=document.getElementById("span");
	var btn=document.getElementById("btn");
	var ex=document.getElementById("ex");
	
	
	var htp = new XMLHttpRequest();

	htp.onreadystatechange = function ()
	{
		if(htp.readyState==4){
			  if(htp.responseText=="1"){
					span.style.display="";
					btn.disabled="disabled";
			  }
			  else{
				  span.style.display="none";
					btn.disabled="";
			  }
		  }
	}
	htp.open("get","checkfile.htm?date="+date.value+"&ex="+ex.value,true);
	htp.send();
}

</script>


</head>

 <s:set var="u" value="${ex }"></s:set> 
<s:set var="ex" value="${e:split(u,',')}"></s:set>
<body> 

<div class="container">
<h3 style="color:red">${e:toUpperCase(ex[0]) }</h3>
<h3 style="color:red">${ex[1] }</h3>
<f:form class="form-horizontal" action="insertfile.htm" method="post" enctype="multipart/form-data">
  
  <div class="form-group">
      <label class="control-label col-sm-2" for="date">Date:</label>
      <div class="col-sm-10">
    	<input type="date" class="form-control" id="date" name="date"  required/>
      </div>
  </div>
  
  <div class="form-group">
      <label class="control-label col-sm-2" for="file">File:</label>
      <div class="col-sm-10">
		<input type="file" class="form-control" name="file" id="file" required/>
		</div>
  </div>
      <div class="col-sm-10">
  		<span id="span" style="display: none; color: red;text-align:center;">File Already Exists</span>
  		</div>
<input type="hidden" name="ex" value="${ex[0]}"   id="ex"/>
  
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />  
   <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
  		<button type="submit" class="btn btn-default" id="btn">Submit</button>      
      </div>
    </div>
    
<h4><a href="<%=request.getContextPath()%>/admin.htm?msg=">Back</a></h4>
    
</f:form>
</div>
 <script src="js/jquery.js">
</script>
<script src="js/bootstrap.min.js">
</script>

 </body>
</html>