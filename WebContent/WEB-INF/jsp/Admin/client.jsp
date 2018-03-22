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
<h2>Upload-ClientFile</h2>
<form class="form-horizontal" action="clientfile.htm" method="post" enctype="multipart/form-data" >
  <div class="form-group">
      <label class="control-label col-sm-2" for="file">File:</label>
      <div class="col-sm-10">
		<input type="file" class="form-control" name="file" id="file" required/>
		</div>
  </div>
  <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
  		<button type="submit" class="btn btn-default" id="btn">Submit</button>      
      </div>
    </div>
    
</form>
</div>
</body>

 <script src="js/jquery.js">
</script>
<script src="js/bootstrap.min.js">
</script>

</html>