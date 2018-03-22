package abc.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

import abc.VO.clientVO;
import abc.VO.confirmVO;

@Repository

public class clientDAO {

	@Autowired SessionFactory sessionFactory;

	public void insert(String filepath) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(filepath);
		String s="/";
		String s1="\\";
		System.out.println(s1);
		
		filepath=filepath.replace("\\", "/");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/office","root","root");
			Statement statement = connection.createStatement();
			String c="Y";
			statement.executeUpdate("load data infile '"+filepath+"' into table clientdetails fields terminated by ',' (clientCode,clientName,clientPhn,clientEmail) set clientConfirm = '"+c+"'  ");	
			
			connection.close();
			statement.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		}

	public void insertc(clientVO clientVO) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(clientVO);
		tr.commit();
		session.close();
	
	}

	public clientVO search(String code) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from clientVO where clientCode like '"+code+"'"); 
		
		clientVO clientVO = null;
		if(query.list().size() == 1)
			clientVO=(clientVO)query.list().get(0);
		
		transaction.commit();
		session.close();
		
		return clientVO;

		
		
	}

	public List getphn(List list) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List phone  =new ArrayList();
		Query query = session.createQuery("from clientVO");
		List c = query.list();
		
		for(int i=0;i<list.size();i++)
		{
			confirmVO confirmVO = (confirmVO)list.get(i);
			
			for(int j=0;j<c.size();j++)
			{
				clientVO clientVO = (clientVO)c.get(j);
				
			}
			
		}
		
		transaction.commit();
		session.close();
		
		return list;
		
	}
	
	
	
}
