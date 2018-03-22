package abc.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import abc.VO.LoginVO;
import abc.VO.RegVO;


@Repository
public class LoginDAO {

	@Autowired
	SessionFactory sessionFactory;

	public void insertReg(RegVO VO){
		
		try{
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(VO);
			tr.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		}

	public void insert(LoginVO loginVO) {
		// TODO Auto-generated method stub
		try{
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(loginVO);
			tr.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		}

	public List getUserAvial() {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		String r ="ROLE_USER";
		Query query = session.createQuery("from LoginVO where role like '"+r+"' ");
		
		List ls = query.list();
		
		tr.commit();
		session.close();
	
		return ls;
	}

	public void userAvailMod(String[] userid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		Query query = session.createQuery("from LoginVO ");
		List u = query.list();
		
		for(int i=0;i<u.size();i++)
		{
			LoginVO loginVO = (LoginVO)u.get(i);
			
			if(loginVO.getRole().equals("ROLE_USER"))
			{
				loginVO.setUa("0");
				session.update(loginVO);
			}
		}
		
		for(int i=0;i<userid.length;i++)
		{
		
			query = session.createQuery("from LoginVO where loginId like '"+userid[i]+"'");
			LoginVO loginVO = (LoginVO)query.list().get(0);
			loginVO.setUa("1");
			session.saveOrUpdate(loginVO);
		}
		tr.commit();
		session.close();
	
	}
	}

