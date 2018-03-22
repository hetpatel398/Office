<%@page import="abc.VO.confirmVO"%>
<%@page import="abc.VO.LoginVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<link href="css/bootstrap.min.css" rel="stylesheet">
<%
	List user = (ArrayList)session.getAttribute("users");
	List c = (ArrayList)session.getAttribute("c");
	String date= (String) session.getAttribute("date");
%>
<div class="container">
<h2>Date:<%=date %></h2>

<table class ="table table-bordered">
	
<tr>
<td >User-Name</td>
<td >Total-Codes</td>
<td >Confirm-Codes</td>
<td >No-Reply-Codes</td>
<td >Not-Confirm-Codes</td>
<td >Yet-to-Confirm-Codes</td>
<td >Confirmation not given due to client concern.</td>
<td >View</td>

</tr>

<%	
	for(int i=0;i<user.size();i++)
	{
		int t=0,co=0,nc=0,nr=0,y=0,cc=0;
		LoginVO loginVO = (LoginVO)user.get(i);
		System.out.println(loginVO.getLoginId());
		String x="",a="";
		for(int j=0;j<c.size();j++)
		{
			confirmVO confirmVO = (confirmVO)c.get(j);
			//System.out.println(confirmVO.getUserid() + " " + loginVO.getLoginId() + " " + confirmVO.getUserid().equals(loginVO.getLoginId()));
			x=confirmVO.getUserid();
			a=""+loginVO.getLoginId();
			System.out.println(a);
			if(x.equals(a))
			{
				t++;
				//System.out.println(confirmVO.getUserid() + " " + loginVO.getLoginId() + " "+t);
				if(confirmVO.getConfirmpin().equals("1"))
					co++;
				else if(confirmVO.getConfirmpin().equals("2"))
					nc++;
				else if(confirmVO.getConfirmpin().equals("3"))
					nr++;
				else if(confirmVO.getConfirmpin().equals("0"))
					y++;
				else if(confirmVO.getConfirmpin().equals("4"))
					cc++;
				
				
			}
			
		}
		System.out.println(t + " " + co +" " +nc + " "+nr +" "+ y +" " + x );
%>	
	
<tr>
<td ><%=loginVO.getUserName() %></td>
<td ><%=t %></td>
<td ><%=co %></td>
<td ><%=nr %></td>
<td ><%=nc %></td>
<td ><%=y %></td>
<td ><%=cc %></td>
<td ><a href="view.htm?date=<%=date%>&userid=<%=a%>">View</a></td>

</tr>
	
<% 		
	}


%>

</table>

<h3><a href="<%=request.getContextPath()%>/super.htm">Back</a></h3>

<h3><a href="j_spring_security_logout?${_csrf.parameterName}=${_csrf.token}">Log-Out</a></h3>

</div>


<body>


 <script src="js/jquery.js">
</script>
<script src="js/bootstrap.min.js">
</script>

</body>
</html>