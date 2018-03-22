package abc.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import abc.DAO.LoginDAO;
import abc.DAO.clientDAO;
import abc.DAO.confirmDAO;
import abc.DAO.dateDAO;
import abc.DAO.fileDAO;
import abc.VO.clientVO;
import abc.VO.confirmVO;
import abc.VO.dateVO;
import abc.VO.fileVO1;

@Controller
public class FileUpload {

	
	@Autowired fileDAO dao;
	@Autowired dateDAO dateDAO;
	@Autowired confirmDAO confirmDAO;
	@Autowired clientDAO clientDAO;
	@Autowired LoginDAO loginDAO;
	
	private static final String UPLOAD_DIRECTORY="/images";
	
	 @RequestMapping(method=RequestMethod.GET,value="home.htm")  
	 public ModelAndView home(){ 
		 
	      return new ModelAndView("home"); 
	 }
	 @RequestMapping(method=RequestMethod.GET,value="uploadclient.htm")  
	 public ModelAndView client(){ 
		 
	      return new ModelAndView("Admin/client"); 
	 }
	
	 @RequestMapping(method=RequestMethod.GET,value="uploadfile.htm")  
	 public ModelAndView uploadFile(){ 
		 
	      return new ModelAndView("Admin/uploadfile"); 
	 }
	
	 @RequestMapping(method=RequestMethod.GET,value="uploadnse.htm")  
	 public ModelAndView uploadnse(@RequestParam("msg") String msg){ 
		 
		 msg = "nse, " + msg;
	      return new ModelAndView("Admin/upload","ex",msg); 
	 }
	 @RequestMapping(method=RequestMethod.GET,value="uploadbse.htm")  
	 public ModelAndView uploadbse(@RequestParam("msg") String msg){ 
		 
		 msg = "bse, " + msg;
	      return new ModelAndView("Admin/upload","ex",msg); 
	 }
	 @RequestMapping(method=RequestMethod.GET,value="uploadnsefo.htm")  
	 public ModelAndView uploadnsefo(@RequestParam("msg") String msg){ 
		 
		 msg = "nsefo, " + msg;
	     return new ModelAndView("Admin/upload","ex",msg); 
	 }
	
	 @RequestMapping(method=RequestMethod.GET,value="addclient.htm")  
	 public ModelAndView addc(){ 
		 
	      return new ModelAndView("Admin/insertclient","data",new clientVO()); 
	 }
	
	 @RequestMapping(method=RequestMethod.POST,value="insertclient.htm")  
	 public ModelAndView insertclient(@ModelAttribute clientVO clientVO){ 
		 
		 
		 this.clientDAO.insertc(clientVO);
		 this.confirmDAO.change(clientVO.getClientCode(),clientVO.getClientConfirm());
	      return new ModelAndView("Admin/uploadfile"); 
	 }

	 @RequestMapping(method=RequestMethod.POST,value="eclient.htm")  
	 public ModelAndView eclient(@ModelAttribute clientVO clientVO,@RequestParam("code") String code,@RequestParam("cname") String cname ){ 
		 
		 clientVO.setClientCode(code);
		 clientVO.setClientCname(cname);
		 
		 this.clientDAO.insertc(clientVO);
		 this.confirmDAO.change(clientVO.getClientCode(),clientVO.getClientConfirm());
	      return new ModelAndView("Admin/uploadfile"); 
	 }
	
	 @RequestMapping(method=RequestMethod.GET,value="viewdates.htm")  
	 public ModelAndView viewdates(@RequestParam("msg") String msg,HttpSession session){ 
		 
		 if(msg.equals("1"))
			 msg="";
		 List list=this.dateDAO.search();
		 if(list.size()>0)
		 {
			 session.setAttribute("dates", list);
			 System.out.println(list + " view dates");
			 return new ModelAndView("Admin/viewdates","msg",msg);
			 
		 }
		 else
		 {
			 msg=msg+" No dates For Distribution";
			 return new ModelAndView("Admin/uploadfile","msg",msg);
		 } 
	 }
	
	 @RequestMapping(method=RequestMethod.GET,value="selectusers.htm")  
	 public ModelAndView selectusers(@RequestParam("date") String date,HttpSession session){ 
		 
		 List users = this.loginDAO.getUserAvial();
		 session.setAttribute("users", users);
		 
		 return new ModelAndView("Admin/selectusers","date",date);
	 }
	 @RequestMapping(method=RequestMethod.POST,value="distribute.htm")  
	 public ModelAndView distribute(HttpSession session,HttpServletRequest request) throws IOException{ 
		 
		 String date = request.getParameter("date");
		 String userid[] = request.getParameterValues("users");
		 System.out.println(date+"distribute");
		 
		 if(userid != null)
		 {
			 this.loginDAO.userAvailMod(userid);
				/* String mydate[]=date.split("-");
				System.out.println(date);
				if(mydate[1].equals("01"))
					mydate[1]="JAN";
				else if(mydate[1].equals("02"))
					mydate[1]="FEB";
				else if(mydate[1].equals("03"))
					mydate[1]="MAR";
				else if(mydate[1].equals("04"))
					mydate[1]="APR";
				else if(mydate[1].equals("05"))
					mydate[1]="MAY";
				else if(mydate[1].equals("06"))
					mydate[1]="JUN";
				else if(mydate[1].equals("07"))
					mydate[1]="JUL";
				else if(mydate[1].equals("08"))
					mydate[1]="AUG";
				else if(mydate[1].equals("09"))
					mydate[1]="SEP";
				else if(mydate[1].equals("10"))
					mydate[1]="OCT";
				else if(mydate[1].equals("11"))
					mydate[1]="NOV";
				else if(mydate[1].equals("12"))
					mydate[1]="DEC";
				
				String gdate=mydate[2] + " " + mydate[1] + " " + mydate[0];
		
			*/	System.out.println(this.dateDAO.check(date));
			 if(this.dateDAO.check(date) > 0)
			 {
				 System.out.println(date);
				 List listofcodes=this.dao.searchcodes(date);
				 System.out.println(listofcodes +" listofcodes");
				 this.confirmDAO.insert(listofcodes, date);
				 System.out.println(listofcodes.size());
				 this.dateDAO.update(date);
				 
				 return new ModelAndView("redirect://viewdates.htm?msg=Codes Distributed Successfully for this Date:"+date);
			 }
			 else 
				 return new ModelAndView("redirect://viewdates.htm?msg=Upload Files for this Date:"+date);
			 
			 
		 }
		 else
		 {
			 return new ModelAndView("redirect://viewdates.htm?msg=Please select valid users:"+date);
		 }
	
	 }
	
	 
	 @RequestMapping(method=RequestMethod.POST,value="insertfile.htm")  
	 public ModelAndView saveFile(@RequestParam("file") CommonsMultipartFile file, @RequestParam("date") String date,@RequestParam("ex") String ex, HttpSession session) throws IOException{ 

		 System.out.println(date);
		 System.out.println(ex);
		 ServletContext context = session.getServletContext();
		 String path=context.getRealPath(UPLOAD_DIRECTORY);
		 
		 String filename=file.getOriginalFilename();
		 String mday = date.split("-")[2];
		 String mmon=date.split("-")[1];
		 String my=date.split("-")[0];
		 System.out.println(filename);
		 int flag=0;
		 if(ex.equals("nse"))
		 {
			 String fmon = filename.substring(3,5);
			 String fdate = filename.substring(5,7);
			 if(filename.substring(0, 3).equals("nse") | filename.substring(0, 3).equals("NSE"))
			 {
				 if(fmon.equals(mmon) && fdate.equals(mday))
					 flag=1;
				 else
					 flag=0;
			 }
				 
		 }
		 else if(ex.equals("bse"))
		 {
			 String fdate = filename.substring(3,5);
			 String fmon = filename.substring(5,7);
			 if(filename.substring(0, 3).equals("bse") | filename.substring(0, 3).equals("BSE"))
			 {
				 if(fmon.equals(mmon) && fdate.equals(mday))
					 flag=1;
				 else
					 flag=0;
			 }
		 }
		 else if(ex.equals("nsefo"))
		 {
			 String fmon = filename.substring(5,7);
			 String fdate = filename.substring(7,9);
			 if(filename.substring(0, 5).equals("nsefo") | filename.substring(0, 5).equals("NSEFO"))
			 {
				 if(fmon.equals(mmon) && fdate.equals(mday))
					 flag=1;
				 else
					 flag=0;
			 }
			
			 
		 }
		 String r = "upload"+ex+".htm";
		 if(flag == 0)
			 return new ModelAndView("redirect:/"+r+"?msg=Please upload valid file");
		 else
		 {
		 
		 
		 System.out.println(path +File.separator+ filename);
		 byte[] bytes = file.getBytes();
		 System.out.println(file.getBytes());
		 BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(path+File.separator+filename)));  
		 
		    stream.write(bytes);  
		    stream.flush();  
		    stream.close();  
		
		 if(this.dao.checkcolumn(path+File.separator+filename,ex) == 0)
		 {
		    int f= this.dao.insert(path+File.separator+filename,ex,date);
		 	if(f != 0)
		 	{
				dateVO dateVO = new dateVO();
				dateVO.setDates(date);
				dateVO.setExchange(ex);
				dateVO.setFpath(path +File.separator+ filename);
				dateVO.setDpin("0");
				dateVO.setRows(""+f);
	
				this.dateDAO.insert(dateVO);		    
				System.out.println(path+File.separator+filename);
				String mydate[]=date.split("-");
				System.out.println(date);
					if(mydate[1].equals("01"))
						mydate[1]="JAN";
					else if(mydate[1].equals("02"))
						mydate[1]="FEB";
					else if(mydate[1].equals("03"))
						mydate[1]="MAR";
					else if(mydate[1].equals("04"))
						mydate[1]="APR";
					else if(mydate[1].equals("05"))
						mydate[1]="MAY";
					else if(mydate[1].equals("06"))
						mydate[1]="JUN";
					else if(mydate[1].equals("07"))
						mydate[1]="JUL";
					else if(mydate[1].equals("08"))
						mydate[1]="AUG";
					else if(mydate[1].equals("09"))
						mydate[1]="SEP";
					else if(mydate[1].equals("10"))
						mydate[1]="OCT";
					else if(mydate[1].equals("11"))
						mydate[1]="NOV";
					else if(mydate[1].equals("12"))
						mydate[1]="DEC";
					
					String gdate=mydate[2] + " " + mydate[1] + " " + mydate[0];
				    
			      return new ModelAndView("redirect:/admin.htm?msg=File Successfully uploaded with "+f+" rows");
				
		 	}
		 	else
		 		return new ModelAndView("redirect:/admin.htm?msg=Duplicate File !! Please Upload valid file");
		 }
		 else
			 return new ModelAndView("redirect:/admin.htm?msg=Not a valid "+ex+" segment file !! Please Check Again");
		 
		}
	 }
	

	@RequestMapping(value = "/user.htm", method = RequestMethod.GET)
	public String user(HttpSession session,Model model,@RequestParam("username") String uname) {
		
		List dates =this.confirmDAO.showdates(uname);
		System.out.println(dates);
		session.setAttribute("ud", dates);
		session.setAttribute("uname", uname);
		return "User/viewdatesuser";
	}
	@RequestMapping(value = "modifyclient.htm", method = RequestMethod.GET)
	public String modifyclient(HttpSession session) {
		
		return "Admin/searchclient";
	}

	@RequestMapping(value = "searchclient.htm", method = RequestMethod.POST)
	public ModelAndView searchclient(HttpSession session,@RequestParam("ccode") String code) {
		
		clientVO clientVO=this.clientDAO.search(code);
		if(clientVO != null)
			return new ModelAndView("Admin/editclient","data",clientVO);
		else
			return new ModelAndView("Admin/searchclient","msg","Enter Valid Client Code");
	}
	
	
	 @RequestMapping(method=RequestMethod.GET,value="showcodes.htm")  
	 public ModelAndView showcodes(@RequestParam("date") String date,HttpSession session){ 
		 
		 System.out.println(date);
		 if(date.contains("/"))
			 date=date.replace("/", "-");
		 String uname=(String)session.getAttribute("uname");
		List codeforuser[]= this.confirmDAO.searchcodes(uname,date);
		
		if(codeforuser[0].size() > 0 | codeforuser[1].size()>0 | codeforuser[2].size()>0 )
		{
			session.setAttribute("confirm", codeforuser[0]);
			session.setAttribute("nconfirm", codeforuser[1]);
			session.setAttribute("nreply", codeforuser[2]);
			System.out.println(codeforuser[0].size() +" "+ codeforuser[1].size() +" "+ codeforuser[2].size());
			return new ModelAndView("User/showcodes","msg",date);
		}
		else
		{
			System.out.println(codeforuser[0].size() +" "+ codeforuser[1].size() +" "+ codeforuser[2].size());
			session.setAttribute("confirm", codeforuser[0]);
			session.setAttribute("nconfirm", codeforuser[1]);
			session.setAttribute("nreply", codeforuser[2]);
			
			return new ModelAndView("User/showcodes","msg","All codes Confirmed for "+date);
		}
			
	       
	 }
	 
	 @RequestMapping(method=RequestMethod.GET,value="deletefile.htm")  
	 public ModelAndView deletefile(@RequestParam("dateid") String dateid,HttpSession session){ 
		  
		 System.out.println(dateid);
		 this.dateDAO.delete(dateid); 
		  
		 return new ModelAndView("redirect://admin.htm?msg=");
	 }
	 
	
	 @RequestMapping(method=RequestMethod.GET,value="showtrades.htm")  
	 public ModelAndView showtrades(@RequestParam("uname") String uname,@RequestParam("date") String date,@RequestParam("code") String code,HttpSession session){ 
		 
		 
		String gdate=date;
		date=date.replace("-", "/");
		System.out.println(date);
		System.out.println(gdate);
			
		List list[]=this.dao.searchtrades(code, gdate,date);
		
		session.setAttribute("nse0", list[0]);
		session.setAttribute("nse1", list[1]);
		
		session.setAttribute("bse0", list[2]);
		session.setAttribute("bse1", list[3]);
		
		session.setAttribute("nsefo0", list[4]);
		session.setAttribute("nsefo1", list[5]);
		
		session.setAttribute("ce", list[6]);
		session.setAttribute("pe", list[7]);
		
		session.setAttribute("details", list[8]);
			
		session.setAttribute("date", date);
	
	      return new ModelAndView("User/showtrades"); 
	 }
	
	 @RequestMapping(method=RequestMethod.POST,value="confirm.htm")  
	 public ModelAndView confirm(@RequestParam("date") String date,@RequestParam("code") String code,HttpSession session,HttpServletRequest request){ 
		 
		 String flag = request.getParameter("select");
		 String comment = request.getParameter("comment");
		 System.out.println(flag + " " + comment);
		// String mydate = date.split("/")[0] + "-" + date.split("/")[1] +"-"+date.split("/")[2];
		 this.confirmDAO.modify(code,date,flag,comment);
		 
		String uname = (String) session.getAttribute("uname");
		 
		 //this.confirmDAO.modify(confirmVO);
	      return new ModelAndView("redirect://showcodes.htm?date="+date); 
	 }
	 @RequestMapping(method=RequestMethod.GET,value="checknrc.htm")  
	 public void checknrc(@RequestParam("date") String date,@RequestParam("code") String code,HttpSession session,HttpServletResponse response) throws IOException{ 
		 
		/* String flag = request.getParameter("select");
		 String comment = request.getParameter("comment");
		 System.out.println(flag + " " + comment);
		*/// String mydate = date.split("/")[0] + "-" + date.split("/")[1] +"-"+date.split("/")[2];
		int cnrc= this.confirmDAO.checknrc(date,code);
		 System.out.println(cnrc);
		String uname = (String) session.getAttribute("uname");
		PrintWriter printWriter =response.getWriter();
		
		if(cnrc <= 4)
			printWriter.write("1");
		else
			printWriter.write("2");
		
		 //this.confirmDAO.modify(confirmVO);
	    printWriter.close();   
	 }
	  
	/* @RequestMapping(method=RequestMethod.POST,value="clientfile.htm")  
	 public ModelAndView saveFile(@RequestParam("file") CommonsMultipartFile file , HttpSession session) throws IOException{ 

		 ServletContext context = session.getServletContext();
		 String path=context.getRealPath(UPLOAD_DIRECTORY);
		 
		 String filename=file.getOriginalFilename();
		 
		 System.out.println(path +File.separator+ filename);
		 byte[] bytes = file.getBytes();
		 System.out.println(file.getBytes());
		 BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(path+File.separator+filename)));  
		 
		    stream.write(bytes);  
		    stream.flush();  
		    stream.close();  
		 
		    
	    System.out.println(path+File.separator+filename);
	    this.clientDAO.insert(path+File.separator+filename);
			
		    
	      return new ModelAndView("redirect://admin.htm?msg=");
	 }*/
	 @RequestMapping(method=RequestMethod.POST,value="clientfile.htm")  
	 public ModelAndView saveFile(@RequestParam("file") CommonsMultipartFile file , HttpSession session) throws IOException{
		 ServletContext context = session.getServletContext();
		 String path=context.getRealPath(UPLOAD_DIRECTORY);
		 
		 String filename=file.getOriginalFilename();
		 
		 System.out.println(path +File.separator+ filename);
		 byte[] bytes = file.getBytes();
		 System.out.println(file.getBytes());
		 BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(path+File.separator+filename)));  
		 
		    stream.write(bytes);  
		    stream.flush();  
		    stream.close();  
		 
		    
	    System.out.println(path+File.separator+filename);
	    this.clientDAO.insert(path+File.separator+filename);
			
		    
	      return new ModelAndView("redirect://admin.htm?msg=");
	
	 }
	 
	 @RequestMapping(method=RequestMethod.GET,value="checkfile.htm")  
	 public void check(@RequestParam("date") String date,@RequestParam("ex") String ex,HttpSession session,HttpServletResponse response) throws IOException{ 
		 
		 PrintWriter printWriter = response.getWriter();
		 if(this.dateDAO.check(date, ex))
			 printWriter.write("1");
		 else
			 printWriter.write("0");
		 
		 printWriter.close();
		
	 }

}
