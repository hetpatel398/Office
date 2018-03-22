<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Formatter"%>
<%@page import="abc.VO.nsefoVO1"%>
<%@page import="abc.VO.bseVO1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="abc.VO.fileVO1"%>
<%@page import="abc.VO.clientVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>

<body>

<div class="container">

<h2>Table</h2>

<%
List details=(List)session.getAttribute("details");
String date=(String)session.getAttribute("date");
String uname=(String)session.getAttribute("uname");
clientVO clientVO =(clientVO) details.get(0);
%>
<table class="table table-bordered">
<tr>
<td>Date:<%=date %></td>
<td>Code:<%=clientVO.getClientCode() %></td>
<td>Client-Name:<%=clientVO.getClientCname() %></td>
<td>Phone No.:<%=clientVO.getClientPhn() %></td>

</tr>
</table>
<%
	List nse0 = (List)session.getAttribute("nse0");
	List nse1 = (List)session.getAttribute("nse1");

	List bse0 = (List)session.getAttribute("bse0");
	List bse1 = (List)session.getAttribute("bse1");

	List nsefo0 = (List)session.getAttribute("nsefo0");
	List nsefo1 = (List)session.getAttribute("nsefo1");

	/* 
	List symbol=(List)session.getAttribute("symbols");
	List trades=(List)session.getAttribute("trades");
	 */
	//System.out.println(nse0+" " + nse0.size());
	//System.out.println(nse1+" " + nse1.size());
	
	
%>
<h2>NSE</h2>
<%
if(nse1.size() > 0)
{
%>
<table class="table table-bordered">
<tr>
<td style="width:200px">Symbol</td>
<td style="width:200px">Buy-Quantity</td>
<td style="width:200px">Buy-Rate</td>
<td style="width:200px">Sell-Quantity</td>
<td style="width:200px">Sell-Rate</td>

</tr>

<% 
	for(int i=0;i<nse1.size();i++)
	{
		fileVO1 fileVO1 = (fileVO1)nse1.get(i);
		double ibq=0,ibr=0,isq=0,isr=0,bcount=0,scount=0,temp=0;
		System.out.println(fileVO1.getSymbol());
		for(int j=0;j<nse0.size();j++)
		{
			fileVO1 fileVO2 = (fileVO1)nse0.get(j);
			if(fileVO2.getSymbol().equals(fileVO1.getSymbol()))
			{
				
				if(fileVO2.getBuySell().equals("1"))
				{
					temp=Double.parseDouble(fileVO2.getTradeQty().trim());
					ibq+=Double.parseDouble(fileVO2.getTradeQty().trim());
					//ibr+=Double.parseDouble(fileVO2.getTradePrice().trim());
					
					ibr = ibr + (temp * Double.parseDouble(fileVO2.getTradePrice().trim()));
					//bcount++;
					System.out.println(ibq + " " + isq + " " + ibr+ " " + fileVO2.getTradeQty().trim() + " " + fileVO1.getSymbol());
				}
				else
				{
					temp=Double.parseDouble(fileVO2.getTradeQty().trim());;
					isq=isq+Double.parseDouble(fileVO2.getTradeQty().trim());
					//isr+=Double.parseDouble(fileVO2.getTradePrice().trim());
					isr = isr + (temp * Double.parseDouble(fileVO2.getTradePrice().trim()));
					//scount++;
		//			System.out.println(fileVO2.getTradeQty().trim());

					//System.out.println(fileVO1.getBuySell() + " " + fileVO1.getSymbol());
				}
				
			}
		}	
		
		double avg1=0;
		if(ibq != 0)
			avg1=(ibr/ibq);
		
		double avg2=0;
		if(isq != 0)
			avg2=(isr/isq);
		
		String x=String.format("%.2f", avg1);
		String y=String.format("%.2f", avg2);

		if(ibq == 0 && ibr == 0 && isq ==0 && isr==0)
			continue;
		
%>
	
<tr>
<td style="width:200px"><%=fileVO1.getSymbol()%></td>
<td style="width:200px"><%=ibq %></td>
<td style="width:200px"><%=x+" Rs" %></td>
<td style="width:200px"><%=isq %></td>
<td style="width:200px"><%=y+" Rs"%></td>
	
</tr>

<%
	}
%>
</table>
<% 
}
else
{	
%>
<h3>No-Trade</h3>
<% 		
}
%>
<h2>BSE</h2>

<%
if(bse1.size() > 0)
{
%>
<table class="table table-bordered">
<tr>
<td style="width:200px">Symbol</td>
<td style="width:200px">Buy-Quantity</td>
<td style="width:200px">Buy-Rate</td>
<td style="width:200px">Sell-Quantity</td>
<td style="width:200px">Sell-Rate</td>

</tr>

<% 
for(int i=0;i<bse1.size();i++)
{
	bseVO1 bseVO1 = (bseVO1)bse1.get(i);
	double ibq=0,ibr=0,isq=0,isr=0,bcount=0,scount=0,temp=0;
	for(int j=0;j<bse0.size();j++)
	{
		bseVO1 bseVO2 = (bseVO1)bse0.get(j);
		if(bseVO2.getSymbol().equals(bseVO1.getSymbol()))
		{
			if(bseVO2.getBuySell().equals("B"))
			{
				temp=Double.parseDouble(bseVO2.getTradedQty().trim());
				ibq+=Double.parseDouble(bseVO2.getTradedQty().trim());
				//ibr+=Double.parseDouble(bseVO2.getPrice().trim());
				//bcount++;
				ibr = ibr + (temp * Double.parseDouble(bseVO2.getPrice().trim()));

				System.out.println(bseVO1.getBuySell() + " " + bseVO1.getSymbol());
			}
			else
			{
				temp=Double.parseDouble(bseVO2.getTradedQty().trim());
				isq+=Double.parseDouble(bseVO2.getTradedQty().trim());
				//isr+=Double.parseDouble(bseVO2.getPrice().trim());
				isr = isr + (temp * Double.parseDouble(bseVO2.getPrice().trim()));
				//scount++;
		//		System.out.println(bseVO2.getTradedQty().trim());
			}
			
		}
	}

	
	System.out.println(ibq + " " + isq + " " + ibr);
	
	double avg1=0;
	if(ibq != 0)
		avg1=(ibr/ibq);
	
	double avg2=0;
	if(isq != 0)
		avg2=(isr/isq);
	
	avg1=avg1/100;
	avg2=avg2/100;

	String x=String.format("%.2f", avg1);
	String y=String.format("%.2f", avg2);

	if(ibq == 0 && ibr == 0 && isq ==0 && isr==0)
		continue;


%>

<tr>
<td style="width:200px"><%=bseVO1.getSymbol()%></td>
<td style="width:200px"><%=ibq %></td>
<td style="width:200px"><%=x+" Rs" %></td>
<td style="width:200px"><%=isq %></td>
<td style="width:200px"><%=y+" Rs" %></td>

</tr>

<%
}
%>
</table>	

<%
}
else
{	
%>
<h3>No-Trade</h3>
<% 		
}
%>

<h2>NSE-FO</h2>

<%
int flag=0;
if(nsefo1.size() > 0)
{
	flag=1;
%>
<table class="table table-bordered">
<tr>
<td style="width:200px">Symbol</td>
<td style="width:200px">Expiry-Date</td>
<td style="width:200px">Option-Type</td>
<td style="width:200px">Strike-Price</td>
<td style="width:200px">Buy-Quantity</td>
<td style="width:200px">Buy-Rate</td>
<td style="width:200px">Sell-Quantity</td>
<td style="width:200px">Sell-Rate</td>

</tr>

<% 
for(int i=0;i<nsefo1.size();i++)
{
	nsefoVO1 nsefoVO1 = (nsefoVO1)nsefo1.get(i);
	String expd=nsefoVO1.getExpiryDate(),opt="",sp="",exp2="";
	double ibq=0,ibr=0,isq=0,isr=0,bcount=0,scount=0,temp=0;
	for(int j=0;j<nsefo0.size();j++)
	{
		nsefoVO1 nsefoVO2 = (nsefoVO1)nsefo0.get(j);
		exp2=nsefoVO2.getExpiryDate();

		if(nsefoVO2.getSymbol().equals(nsefoVO1.getSymbol()) && !(nsefoVO2.getOptionType().equals("CE") || nsefoVO2.getOptionType().equals("PE")) && expd.equals(exp2))
		{
			
			if(nsefoVO2.getBuySell().equals("1"))
			 {
				temp=Double.parseDouble(nsefoVO2.getQtyTraded().trim());
				ibq+=Double.parseDouble(nsefoVO2.getQtyTraded().trim());
				//ibr+=Double.parseDouble(nsefoVO2.getPrice().trim());
				ibr = ibr + (temp * Double.parseDouble(nsefoVO2.getPrice().trim()));
				
				//bcount++;
				
			}
			else
			{
				temp=Double.parseDouble(nsefoVO2.getQtyTraded().trim());
				isq=isq+Double.parseDouble(nsefoVO2.getQtyTraded().trim());
				//isr+=Double.parseDouble(nsefoVO2.getPrice().trim());
				//scount++;
				//System.out.println(nsefoVO2.getQtyTraded().trim());
				isr = isr + (temp * Double.parseDouble(nsefoVO2.getPrice().trim()));
				
			}
		
	 	}
	}	
	System.out.println(ibq + " " + isq + " "+expd + " " + opt + " " +expd.length() + " "+opt.length());
	
	double avg1=0;
	if(ibq != 0)
		avg1=(ibr/ibq);

	double avg2=0;
	if(isq != 0)
		avg2=(isr/isq);
	
	
	String x=String.format("%.2f", avg1);
	String y=String.format("%.2f", avg2);
	
 	 if(ibq == 0 && ibr == 0 && isq ==0 && isr==0)
 		continue;
 
%>

<tr>
<td style="width:200px"><%=nsefoVO1.getSymbol()%></td>
<td style="width:200px"><%=expd %></td>
<td style="width:200px"><%=opt %></td>
<td style="width:200px"><%=sp %></td>
<td style="width:200px"><%=ibq %></td>
<td style="width:200px"><%=x+" Rs" %></td>
<td style="width:200px"><%=isq %></td>
<td style="width:200px"><%=y+" Rs" %></td>

</tr>

<%
}
}
%>
<% 

List ce = (List)session.getAttribute("ce");
List pe = (List)session.getAttribute("pe");

if(ce.size() > 0)
{
	flag=1;
for(int i=0;i<ce.size();i++)
{
	nsefoVO1 nsefoVO1 = (nsefoVO1)ce.get(i);
	String sp="",expd=nsefoVO1.getExpiryDate(),op="",exp2="";
	double ibq=0,ibr=0,isq=0,isr=0,bcount=0,scount=0,temp=0;
	for(int j=0;j<nsefo0.size();j++)
	{
		nsefoVO1 nsefoVO2 = (nsefoVO1)nsefo0.get(j);
		exp2=nsefoVO2.getExpiryDate();
		if(nsefoVO1.getSymbol().equals(nsefoVO2.getSymbol()) && nsefoVO1.getOptionType().equals(nsefoVO2.getOptionType()) && 
			nsefoVO1.getStrikePrice().equals(nsefoVO2.getStrikePrice()) && expd.equals(exp2))
		{
			if(nsefoVO2.getBuySell().equals("1"))
			 {
				temp=Double.parseDouble(nsefoVO2.getQtyTraded().trim());
				ibq+=Double.parseDouble(nsefoVO2.getQtyTraded().trim());
				//ibr+=Double.parseDouble(nsefoVO2.getPrice().trim());
				ibr = ibr + (temp * Double.parseDouble(nsefoVO2.getPrice().trim()));
				
				//bcount++;
				
			}
			else
			{
				temp=Double.parseDouble(nsefoVO2.getQtyTraded().trim());
				isq=isq+Double.parseDouble(nsefoVO2.getQtyTraded().trim());
				//isr+=Double.parseDouble(nsefoVO2.getPrice().trim());
				//scount++;
				//System.out.println(nsefoVO2.getQtyTraded().trim());
				isr = isr + (temp * Double.parseDouble(nsefoVO2.getPrice().trim()));
				
			}
		}
		sp=nsefoVO1.getStrikePrice();
		expd=nsefoVO1.getExpiryDate();
		op=nsefoVO1.getOptionType();
	}
	double avg1=0;
	if(ibq != 0)
		avg1=(ibr/ibq);

	double avg2=0;
	if(isq != 0)
		avg2=(isr/isq);
	
	
	String x=String.format("%.2f", avg1);
	String y=String.format("%.2f", avg2);
	
	 if(ibq == 0 && ibr == 0 && isq ==0 && isr==0)
		continue;
 
	
%>
<tr>
<td style="width:200px"><%=nsefoVO1.getSymbol()%></td>
<td style="width:200px"><%=expd %></td>
<td style="width:200px"><%=op %></td>
<td style="width:200px"><%=sp %></td>
<td style="width:200px"><%=ibq %></td>
<td style="width:200px"><%=x+" Rs" %></td>
<td style="width:200px"><%=isq %></td>
<td style="width:200px"><%=y+" Rs" %></td>

</tr>

<% 	
}
}
%>
<% 
if(pe.size() > 0)
{
	flag=1;
for(int i=0;i<pe.size();i++)
{
	nsefoVO1 nsefoVO1 = (nsefoVO1)pe.get(i);
	String sp="",expd=nsefoVO1.getExpiryDate(),opt="",exp2="";
	double ibq=0,ibr=0,isq=0,isr=0,bcount=0,scount=0,temp=0;
	for(int j=0;j<nsefo0.size();j++)
	{
		nsefoVO1 nsefoVO2 = (nsefoVO1)nsefo0.get(j);
		exp2=nsefoVO2.getExpiryDate();
		if(nsefoVO1.getSymbol().equals(nsefoVO2.getSymbol()) && nsefoVO1.getOptionType().equals(nsefoVO2.getOptionType()) && 
			nsefoVO1.getStrikePrice().equals(nsefoVO2.getStrikePrice())	 && expd.equals(exp2))
		{
			if(nsefoVO2.getBuySell().equals("1"))
			 {
				temp=Double.parseDouble(nsefoVO2.getQtyTraded().trim());
				ibq+=Double.parseDouble(nsefoVO2.getQtyTraded().trim());
				//ibr+=Double.parseDouble(nsefoVO2.getPrice().trim());
				ibr = ibr + (temp * Double.parseDouble(nsefoVO2.getPrice().trim()));
				
				//bcount++;
				
			}
			else
			{
				temp=Double.parseDouble(nsefoVO2.getQtyTraded().trim());
				isq=isq+Double.parseDouble(nsefoVO2.getQtyTraded().trim());
				//isr+=Double.parseDouble(nsefoVO2.getPrice().trim());
				//scount++;
				//System.out.println(nsefoVO2.getQtyTraded().trim());
				isr = isr + (temp * Double.parseDouble(nsefoVO2.getPrice().trim()));
				
			}
		}
		sp=nsefoVO1.getStrikePrice();
		expd=nsefoVO1.getExpiryDate();
		opt=nsefoVO1.getOptionType();
	}
	System.out.println(opt);
	double avg1=0;
	if(ibq != 0)
		avg1=(ibr/ibq);

	double avg2=0;
	if(isq != 0)
		avg2=(isr/isq);
	
	
	String x=String.format("%.2f", avg1);
	String y=String.format("%.2f", avg2);
	
	if(ibq == 0 && ibr == 0 && isq ==0 && isr==0)
		continue;
	 
%>
<tr>
<td style="width:200px"><%=nsefoVO1.getSymbol()%></td>
<td style="width:200px"><%=expd %></td>
<td style="width:200px"><%=opt %></td>
<td style="width:200px"><%=sp %></td>
<td style="width:200px"><%=ibq %></td>
<td style="width:200px"><%=x+" Rs" %></td>
<td style="width:200px"><%=isq %></td>
<td style="width:200px"><%=y+" Rs" %></td>

</tr>
<%
}
}

if(flag == 0)
{	
%>
	
<h3>No-Trade</h3>
<% 		
}
%>
</table> 
	 
<form class="form-horizontal" action="confirm.htm" method="post">
  <div class="radio input-group-lg">
  	<label  ><input type="radio" name="select" value="1" >Confirm</label><br>
  	<label ><input type="radio" name="select" value="2">Not-Confirm</label><br>
  	<label ><input type="radio" name="select" value="3" id="nr" onclick="fn(this)" >No-Reply</label><br>
  </div>
  <br>
 <div class="form-group"> 
 	<label for="comment">Comment:</label>
  	<input type="text" name="comment" id="c" required />
  </div>
 
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
    <button type="submit" class="btn btn-info">Submit</button>
 	<a class="btn btn-info" role="button" href="showcodes.htm?date=<%=date%>">Back</a>
 
    </div>
  </div>
 
  
  <input type="hidden" name="code" id="code" value=<%=clientVO.getClientCode()%>>
  <input type="hidden" name="date" id="date" value=<%=date%>>
  <input type="hidden" name="select1" id="x" />
  <input type="hidden" name="comment1" id="y" >
  
  
</form>	 
 <%-- <a class="btn btn-info" role="button" href="confirm.htm?code=<%=clientVO.getClientCode()%>&date=<%=date%>&flag=1">Confirm</a>
 <a class="btn btn-info" role="button" href="confirm.htm?code=<%=clientVO.getClientCode()%>&date=<%=date%>&flag=2">Not-Confirm</a>
 
  <a class="btn btn-info" role="button" href="confirm.htm?code=<%=clientVO.getClientCode()%>&date=<%=date%>&flag=3">No-Reply</a>
  --%> 
 
</div>

<script type="text/javascript">
function fn(x)
{
	//alert(x.value);
	var code=document.getElementById("code");
	var date=document.getElementById("date");
	var htp = new XMLHttpRequest();
	//alert(code.value);
	//alert(date.value);
	htp.onreadystatechange = function ()
	{
		if(htp.readyState == 4)
		{
			//alert(htp.responseText);
			if(htp.responseText =="1" )
			{
				var today = new Date();
				var h = today.getHours();
				var m = today.getMinutes();
				var s = today.getSeconds();
				//alert(h + ":" + m + ":" + s)
				
				document.getElementById("c").value=h + ":" + m + ":" + s;
				
			}
			else
			{
				var x=document.getElementById("x");
				//alert(x.name)
				x.name="select";
				x.value="3";
				//alert(x.name)
				
				
				var x=document.getElementById("y");
				//alert(y.name)
				y.name="comment";
				y.value="";
				//alert(y.name)
				
				document.getElementById("nr").disabled="true";
				document.getElementById("c").disabled="true";
				
				
				
			}
		}
	}
	htp.open("get","checknrc.htm?code="+code.value+"&date="+date.value,true);
	htp.send();
 
	//alert(document.getElementById("c").value);
}

</script>
 
<script src="js/jquery.js">
</script>

<script src="js/bootstrap.min.js">
</script>

 
 </body>
</html>