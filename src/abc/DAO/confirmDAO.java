package abc.DAO;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import abc.VO.LoginVO;
import abc.VO.bseVO1;
import abc.VO.clientVO;
import abc.VO.confirmVO;
import abc.VO.fileVO1;
import abc.VO.nsefoVO1;

@Repository
public class confirmDAO {

	@Autowired SessionFactory sessionFactory;

	public void insert(List listofcodes,String date) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String user="ROLE_USER";
		Query query = session.createQuery("from LoginVO where role like '%"+user+"%' and ua like '"+1+"' ");
		List users=query.list();
		int b = listofcodes.size()/users.size(),u=0,i;
		for(i=0;i<(users.size()*b);i+=b)
		{
			LoginVO loginVO=(LoginVO)users.get(u);
			for(int j=i;j<(i+b);j++)
			{
				confirmVO confirmVO = new confirmVO();
				String code=(String)listofcodes.get(j);
				code=code.trim();
				query = session.createQuery("from clientVO where clientcode='"+code+"'");
				clientVO clientVO = null ;
				if(query.list().size() > 0)
					clientVO=(clientVO)query.list().get(0);
				if(clientVO != null) 
				{	
					if(clientVO.getClientConfirm().equals("N"))
						confirmVO.setClientconfirm("N");
					else
						confirmVO.setClientconfirm("Y");
				}
				else
				{
					confirmVO.setClientconfirm("X");
					confirmVO=null;
					continue;
				}
				System.out.println(loginVO.getLoginId() + " " +listofcodes.get(j) +" " +  j + loginVO.getUserName());
				confirmVO.setConfirmpin("0");
				confirmVO.setTrdate(date);
				confirmVO.setCcode((String)listofcodes.get(j));	
				confirmVO.setUserid(""+loginVO.getLoginId());
				session.save(confirmVO);
			}
			u++;
		}
		for( ;i<listofcodes.size();i++)
		{
			LoginVO loginVO=(LoginVO)users.get(0);
			confirmVO confirmVO = new confirmVO();
			String code=(String)listofcodes.get(i);
			code=code.trim();
			query = session.createQuery("from clientVO where clientcode='"+code+"'");
			clientVO clientVO = null ;
			if(query.list().size() > 0)
				clientVO=(clientVO)query.list().get(0);
			if(clientVO != null) 
			{	
				if(clientVO.getClientConfirm().equals("N"))
					confirmVO.setClientconfirm("N");
				else
					confirmVO.setClientconfirm("Y");
			}
			else
			{
				confirmVO.setClientconfirm("X");
				confirmVO=null;
				continue;
			}
				
			System.out.println(loginVO.getLoginId() + " " +listofcodes.get(i) +" " +  i + loginVO.getUserName());
			confirmVO.setConfirmpin("0");
			confirmVO.setTrdate(date);
			confirmVO.setCcode((String)listofcodes.get(i));	
			confirmVO.setUserid(""+loginVO.getLoginId());
			session.save(confirmVO);
			
		}
		
		
		transaction.commit();
		session.close();

		
	}

	public List showdates(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from LoginVO where userName like '%"+username+"%'");
		LoginVO  loginVO =(LoginVO)query.list().get(0);
		
		System.out.println(loginVO.getLoginId() + " " + username);
		query = session.createQuery("from confirmVO where userid='"+loginVO.getLoginId()+"' group by trdate");
		List dates = query.list();
		transaction.commit();
		session.close();
	
		return dates;
	}

	
	public List[] searchcodes(String uname, String date) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from LoginVO where userName='"+uname+"'");
		LoginVO  loginVO =(LoginVO)query.list().get(0);
		
		System.out.println(loginVO.getLoginId() + " " + uname);
		query = session.createQuery("from confirmVO where userid='"+loginVO.getLoginId()+"'  and trdate like '%"+date+"%'");
		List dates = query.list();
		List c[] = new ArrayList[3];
		c[0]=new ArrayList<>();
		c[1]=new ArrayList<>();
		c[2]=new ArrayList<>();
		
		for(int i=0;i<dates.size();i++)
		{
			confirmVO confirmVO = (confirmVO)dates.get(i);
			if(confirmVO.getConfirmpin().equals("0"))
				c[0].add(confirmVO);
			else if(confirmVO.getConfirmpin().equals("2"))
				c[1].add(confirmVO);
			else if(confirmVO.getConfirmpin().equals("3") )
				c[2].add(confirmVO);
		}
		
		System.out.println(dates);
		transaction.commit();
		session.close();
	
		return c;
		
		
	}

	public void modify(String code,String date,String flag, String comment) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		date=date.replace("/", "-");

		Query query = session.createQuery("from confirmVO where ccode like '%"+code+"' and trdate like '%"+date+"%'");
		System.out.println(code + " " + date);
		confirmVO confirmVO = (confirmVO)query.list().get(0);
		
		
		if(flag.equals("1"))
		{

			String cc = confirmVO.getComment();
			
			confirmVO.setComment(cc+" "+comment);
			confirmVO.setConfirmpin("1");
		}
		else if(flag.equals("2"))
		{

			String cc = confirmVO.getComment();
			
			confirmVO.setComment(cc+" "+comment);
			confirmVO.setConfirmpin("2");
		}
		else if(flag.equals("3"))
		{
			int nrc=Integer.parseInt(confirmVO.getNoreplycount());
			
			String cc = confirmVO.getComment();
			if(nrc > 5)
				confirmVO.setComment(cc+comment);
			else
				confirmVO.setComment(cc+","+comment);
			confirmVO.setConfirmpin("3");
			nrc++;
			confirmVO.setNoreplycount(""+nrc);
		}
		else if(flag.equals("4"))
		{
			comment = comment + "confirmation not required by client";
			confirmVO.setComment(comment);
			confirmVO.setConfirmpin("4");
		}
		
		session.saveOrUpdate(confirmVO);
		transaction.commit();
		session.close();
	}

	public List[] report(String date) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List list []  =new ArrayList[3];
		Query query = session.createQuery("from confirmVO where trdate like '%"+date+"%'");
		list[0] = query.list();
		System.out.println(list[0]);
		String role="ROLE_USER";
		query = session.createQuery("from LoginVO where role like '%"+role+"%' ");
		list[1] = query.list();
		
		System.out.println(list[1]);
		transaction.commit();
		session.close();
		
		return list;
		
	}

	public List[] view(String date, String uid) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println(date + uid);
		Query query = session.createQuery("from confirmVO where trdate like '%"+date+"%' and userid='"+uid+"'");
		List vcode = query.list();
		List c[] = new ArrayList[5];
		c[0]=new ArrayList<>();
		c[1]=new ArrayList<>();
		c[2]=new ArrayList<>();
		c[3]=new ArrayList<>();
		c[4]=new ArrayList<>();
		
		for(int i=0;i<vcode.size();i++)
		{
			confirmVO confirmVO = (confirmVO)vcode.get(i);
			if(confirmVO.getConfirmpin().equals("0"))
				c[0].add(confirmVO);
			else if(confirmVO.getConfirmpin().equals("2"))
				c[1].add(confirmVO);
			else if(confirmVO.getConfirmpin().equals("3"))
				c[2].add(confirmVO);
			else if(confirmVO.getConfirmpin().equals("1"))
				c[3].add(confirmVO);
			else if(confirmVO.getConfirmpin().equals("4"))
				c[4].add(confirmVO);
			
			
		}
		
		System.out.println(c[0]);
		System.out.println(c[1]);
		System.out.println(c[2]);
		System.out.println(c[3]);
		System.out.println(c[4]);
		
		transaction.commit();
		session.close();
	
		return c;
	
	}

	public void change(String clientCode,String clientConfirm) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from confirmVO where ccode like '%" +clientCode+ "%' ");
		
		for(int i=0;i<query.list().size();i++)
		{
			confirmVO cVo = (confirmVO)query.list().get(i);
			cVo.setClientconfirm(clientConfirm);
			session.saveOrUpdate(cVo);
		}

		transaction.commit();
		session.close();
	
		
	}

	public void delete(String date) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/office","root","root");
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from confirmation where trdate like '%"+date+"%'");
			
			connection.close();
			statement.close();
		} catch (ClassNotFoundException | SQLException  | UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void insertrecordpath(String date) {
		// TODO Auto-generated method stub
		date = date.split("-")[2] + "." + date.split("-")[1] + "."  + date.split("-")[0] ;
		
		System.out.println(date);
		File folder = new File("F:/"+date+"/");
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println("File " + listOfFiles[i].getName());
		        
		        
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
		
	}

	public List getcodes(String date) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List list   =new ArrayList();
		Query query = session.createQuery("from confirmVO where trdate like '%"+date+"%'");
		list = query.list();
		System.out.println( date);
		
		transaction.commit();
		session.close();
		
		return list;
	}

	public int checknrc(String date, String code) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		date=date.replace("/", "-");

		Query query = session.createQuery("from confirmVO where ccode like '%"+code+"' and trdate like '%"+date+"%'");
		System.out.println(code + " " + date);
		confirmVO confirmVO = (confirmVO)query.list().get(0);
		transaction.commit();
		session.close();
		
		return Integer.parseInt(confirmVO.getNoreplycount());
	}
	
	
}
