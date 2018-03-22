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

import abc.VO.dateVO;

@Repository

public class dateDAO {
	
	@Autowired SessionFactory sessionFactory;
	@Autowired confirmDAO confirmDAO;
	
	public void insert(dateVO dateVO) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(dateVO);
		transaction.commit();
		session.close();
		
	}

	public List search() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from dateVO where dpin like '"+0+"' group by dates");
	
		List list = query.list();
		System.out.println(list);
		transaction.commit();
		session.close();
		return list;
	}

	public int check(String date) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from dateVO where dates like '%"+date+"%' and dpin like '"+0+"'");
	
		System.out.println(date);
		List list = query.list();
		int flag=list.size();
		/*String flag="";
		int i=0;
		if(list.size() == 3)
		{
			for(i=0;i<list.size();i++)
			{
				dateVO dateVO = (dateVO)list.get(i);
				if(!(dateVO.getDpin().equals("0")))
					break;
			}
			if(i == 3)
				flag="2";
			else if(i<3)
				flag="3";
			
		}
		else
			flag="1";
		*/
		
		
		transaction.commit();
		session.close();
		System.out.println(flag);
		return flag;
		
		
		// TODO Auto-generated method stub
		
	}

	public List show() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List list = new ArrayList();
		Query query = session.createQuery("from dateVO");
		list = query.list();
		transaction.commit();
		session.close();
		return list;
		
	}

	public void delete(String dateid) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from dateVO where dateId='"+dateid+"'");
		dateVO dateVO = (dateVO) query.list().get(0);
		
		/*String bdate=dateVO.getDates().replace("-", "/");
		String date[]=dateVO.getDates().split("-");
		String mydate=""+date[2];
		System.out.println(bdate + "see this date " );
		
		if(date[1].equals("01"))
			mydate=mydate+" JAN ";
		if(date[1].equals("02"))
			mydate=mydate+" FEB ";
		if(date[1].equals("03"))
			mydate=mydate+" MAR ";
		if(date[1].equals("04"))
			mydate=mydate+" APR ";
		if(date[1].equals("05"))
			mydate=mydate+" MAY ";
		if(date[1].equals("06"))
			mydate=mydate+" JUN ";
		if(date[1].equals("07"))
			mydate=mydate+" JULY ";
		if(date[1].equals("08"))
			mydate=mydate+" AUG ";
		if(date[1].equals("09"))
			mydate=mydate+" SEP ";
		if(date[1].equals("10"))
			mydate=mydate+" OCT ";
		if(date[1].equals("11"))
			mydate=mydate+" NOV ";
		if(date[1].equals("12"))
			mydate=mydate+" DEC ";
		
		mydate=mydate+date[0];
		System.out.println(mydate);
			*/
		String mydate=dateVO.getDates();
		File fname = new File(dateVO.getFpath());
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/office","root","root");
				Statement statement = connection.createStatement();
				if(dateVO.getExchange().equals("nse") | dateVO.getExchange().equals("nsefo"))
				{
					if(dateVO.getExchange().equals("nse"))
						statement.executeUpdate("delete from filense where mydate like '%"+mydate+"%'");
					else
						statement.executeUpdate("delete from filensefo where mydate like '%"+mydate+"%'");
				}
				else
				{
					if(dateVO.getExchange().equals("bse"))
						statement.executeUpdate("delete from filebse where mydate like '%"+mydate+"%'");
					
				}
				
				System.out.println(fname.delete());
				session.delete(dateVO);
				
				connection.close();
				statement.close();
			} catch (ClassNotFoundException | SQLException  | UnsupportedOperationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		this.confirmDAO.delete(dateVO.getDates());
		transaction.commit();
		session.close();
		
		
		
		
	}

	public boolean check(String date, String ex) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from dateVO where dates like '%"+date+"%' and exchange='"+ex+"'");
		boolean flag;
		if(query.list().isEmpty())
			flag=false;
		else
			flag= true;
		transaction.commit();
		session.close();
		return flag;
	}

	public void update(String date) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from dateVO where dates like '%"+date+"%'");
		List list = query.list();
		
		for(int i=0;i<list.size();i++)
		{
			dateVO dateVO = (dateVO)list.get(i);
			dateVO.setDpin("1");
			session.update(dateVO);	
		}
		transaction.commit();
		session.close();
		
	}

	public List searchx() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from dateVO where dpin like '"+1+"' group by dates");
	
		List list = query.list();
		System.out.println(list);
		transaction.commit();
		session.close();
		return list;


	}

	public List getDataFromRange(String from, String to) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from dateVO where dates between '%"+from+"%' and '%"+to+"%' ");
	
		List list = query.list();
		System.out.println(list);
		transaction.commit();
		session.close();
		return list;
	
		
	}
	
}
