	package abc.controller;


import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import abc.DAO.LoginDAO;
import abc.DAO.clientDAO;
import abc.DAO.confirmDAO;
import abc.DAO.dateDAO;
import abc.VO.LoginVO;
import abc.VO.RegVO;
import abc.VO.clientVO;


@Controller
public class RegController {

	@Autowired LoginDAO dao; 
	@Autowired dateDAO datedao;
	@Autowired confirmDAO confirmDAO;
	@Autowired clientDAO clientDAO;
	
	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public String loadLogin(Model model,HttpSession session,RegVO vo) {
		System.out.println("123");
		return("Admin/Login");
	}
	
	@RequestMapping(value = "/reg.htm", method = RequestMethod.GET)
	public ModelAndView loadReg(Model model,HttpSession session,RegVO vo) {
		
		return new ModelAndView("Admin/Reg","reg",new RegVO());
		
	}
	
	@RequestMapping(value = "/insert.htm", method = RequestMethod.POST)
	public ModelAndView insert(@RequestParam ("un") String un,@RequestParam ("pswd") String pswd, Model model,HttpSession session,RegVO vo,LoginVO loginVO) {
		loginVO.setUserName(un);
		loginVO.setPassword(pswd);
		loginVO.setEnabled("1");
		loginVO.setRole("ROLE_USER");
	
		this.dao.insert(loginVO);
		
		vo.setLoginVO(loginVO);
		this.dao.insertReg(vo);
		
		return new ModelAndView("Admin/Login");
	}
	
	@RequestMapping(value = "/admin.htm", method = RequestMethod.GET)
	public ModelAndView admin(HttpSession session,Model model,@RequestParam("msg") String msg) {
		
		System.out.println(msg);
		List date=this.datedao.show();
		session.setAttribute("date", date);
		System.out.println("in admin" + date);
		
		return new ModelAndView("Admin/uploadfile","msg",msg);
	}
	
	@RequestMapping(value = "daterange.htm", method = RequestMethod.GET)
	public ModelAndView daterange(HttpSession session,Model model) {
		
		return new ModelAndView("Admin/daterange");
	}
	@RequestMapping(value = "checkdaterange.htm", method = RequestMethod.POST)
	public void checkdaterange(HttpSession session,HttpServletRequest request) {
		
		String dr = request.getParameter("daterange");
		String d[] = dr.split("-");
		String e = d[1].trim();
		String w = d[0].trim();
		
		String from = e.split("/")[2] + "-" +e.split("/")[0] + "-"+e.split("/")[1] ;
		String to = w.split("/")[2] + "-" +w.split("/")[0] + "-"+w.split("/")[1] ;
	
		this.datedao.getDataFromRange(from,to);
		syso
		
		
		
		System.out.println(dr);
	}

	
	//*********************************************
	@RequestMapping(value = "super.htm", method = RequestMethod.GET)
	public ModelAndView superadmin(HttpSession session,Model model) {
		
		 List dates=this.datedao.searchx();

		System.out.println("in admin");
		
		 if(dates.size() > 0 )
		 {
			 session.setAttribute("d", dates);
			 return new ModelAndView("Admin/super","msg","");
		 }
		 else
			 return new ModelAndView("Admin/super","msg","No Dates available to generate report");
		
		
	}
	@RequestMapping(value = "/indexsadmin.htm", method = RequestMethod.GET)
	public ModelAndView index(HttpSession session,Model model) {
		
		return new ModelAndView("Admin/sindex");
	}
	
	/*@RequestMapping(value = "getrecordings.htm", method = RequestMethod.GET)
	public ModelAndView getrecords(HttpSession session,Model model) {
		
		List dates=this.datedao.search();

		System.out.println("in admin");
		
		 if(dates.size() > 0 )
		 {
			 session.setAttribute("d", dates);
			 return new ModelAndView("Admin/selectdate","msg","");
		 }
		 else
			 return new ModelAndView("Admin/selectdate","msg","No Dates available to get Recordings");

		
	}
*/	@RequestMapping(value = "insertrecord.htm", method = RequestMethod.POST)
	public ModelAndView insertrecord(HttpSession session,Model model,@RequestParam("date") String date) {
		
		List list = this.confirmDAO.getcodes(date);
		List phones = this.clientDAO.getphn(list);
		this.confirmDAO.insertrecordpath(date);
		return new ModelAndView("Admin");
	}
	
	@RequestMapping(value = "showreport.htm", method = RequestMethod.POST)
	public ModelAndView showreport(HttpSession session,Model model,@RequestParam("date") String date) {
		
		List list[]=this.confirmDAO.report(date);
		
		session.setAttribute("users", list[1]);
		session.setAttribute("c", list[0]);
		session.setAttribute("date", date);
		
		return new ModelAndView("Admin/showreport");
	}
	@RequestMapping(value="view.htm" , method=RequestMethod.GET)
	public ModelAndView view(Model model,HttpSession session,@RequestParam("date") String date,@RequestParam("userid") String uid){
		List cfadmin[]=this.confirmDAO.view(date,uid);
		
		if(cfadmin[0].size() > 0 | cfadmin[1].size()>0 | cfadmin[2].size()>0 |cfadmin[3].size()>0 )
		{
			session.setAttribute("yconfirm", cfadmin[0]);
			session.setAttribute("nconfirm", cfadmin[1]);
			session.setAttribute("nreply", cfadmin[2]);
			session.setAttribute("confirm", cfadmin[3]);
			session.setAttribute("cconfirm", cfadmin[4]);
			
			
			
			System.out.println(cfadmin[0].size() +" "+ cfadmin[1].size() +" "+ cfadmin[2].size() + " " + cfadmin[3].size());
			return new ModelAndView("Admin/viewsa","msg","");
		}
		else
		{

			session.setAttribute("yconfirm", cfadmin[0]);
			session.setAttribute("nconfirm", cfadmin[1]);
			session.setAttribute("nreply", cfadmin[2]);
			session.setAttribute("confirm", cfadmin[3]);
			session.setAttribute("cconfirm", cfadmin[4]);
			
			System.out.println(cfadmin[0].size() +" "+ cfadmin[1].size() +" "+ cfadmin[2].size());
			return new ModelAndView("Admin/viewsa","msg","");
		}
		
		

	}		

	@RequestMapping(value="/logout.htm" , method=RequestMethod.GET)
	public String logout(Model model,HttpSession session){
	
		session.invalidate();		
		System.out.println("*****Successfully Loggedout******");
		return("Admin/Login");

	}		
}
