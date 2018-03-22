package abc.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import abc.VO.bseVO1;
import abc.VO.clientVO;
import abc.VO.fileVO1;
import abc.VO.nsefoVO1;

@Repository
public class fileDAO {

	@Autowired SessionFactory sessionFactory;
	
		public List[] searchtrades(String code,String gdate,String date) {
		// TODO Auto-generated method stub
			List list[] = new ArrayList[9];
			
		System.out.println(code);
		code=code.trim();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from fileVO1 where ClientCode like '%"+code+"' and mydate like '"+gdate+"' ");
		list[0]=query.list();
		query=session.createQuery("from fileVO1 where ClientCode like '%"+code+"' and mydate like '"+gdate+"' group by Symbol");
		list[1]=query.list();
		
		query = session.createQuery("from bseVO1 where ClientAC like '%"+code+"' and TradeEntryDate like '%"+date+"%'");
		list[2]=query.list();
		query=session.createQuery("from bseVO1 where ClientAC like '%"+code+"' and TradeEntryDate like '%"+date+"%' group by Symbol");
		list[3]=query.list();
		
		query = session.createQuery("from nsefoVO1 where ClientCode like '%"+code+"' and mydate like '"+gdate+"' ");
		list[4]=query.list();
		query=session.createQuery("from nsefoVO1 where ClientCode like '%"+code+"' and mydate like '"+gdate+"' group by Symbol,ExpiryDate");
		list[5]=query.list();
		
		String c="CE",p="PE";
		query=session.createQuery("from nsefoVO1 where ClientCode like '%"+code+"' and mydate like '"+gdate+"' and OptionType like '"+c+"' group by StrikePrice ");
		list[6]=query.list();
		
		query=session.createQuery("from nsefoVO1 where ClientCode like '%"+code+"' and mydate like '"+gdate+"' and OptionType like '"+p+"' group by StrikePrice ");
		list[7]=query.list();
		
		
		System.out.println(list[0] + " " +list[0].size()+ " "+list[1]+" " + list[1].size());
		
		query=session.createQuery("from clientVO where clientCode like '%"+code+"'");
		list[8]=query.list();
		
		System.out.println(list[0]);
		System.out.println(list[1]);
		System.out.println(list[2]);
		System.out.println(list[3]);
		System.out.println(list[4]);
		System.out.println(list[5]);
		System.out.println(list[6]);
		System.out.println(list[7]);
		System.out.println(list[8]);
		
		transaction.commit();
		session.close();
		return list;
	}

	public List searchcodes(String mydate) throws IOException {
		// TODO Auto-generated method stub
		
		List code[]  = new ArrayList[3];
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println(mydate);
		Query query = session.createQuery("from fileVO1 where mydate like '%"+mydate+"%' and ClientCode not like '          ' ");
		code[0] = query.list();
		query = session.createQuery("from bseVO1 where mydate like '%"+mydate+"%' and ClientAC not like '          '");
		code[1]=query.list();
		query = session.createQuery("from nsefoVO1 where mydate like '%"+mydate+"%' and ClientCode not like '          ' ");
		code[2]=query.list();
		
		List flist=new ArrayList<>(); 
		for(int i=0;i<code[0].size();i++)
		{
			if(!flist.contains(((fileVO1)code[0].get(i)).getClientCode()))
				flist.add(((fileVO1)code[0].get(i)).getClientCode());
		}
			
		for(int i=0;i<code[1].size();i++)
		{
			if(!flist.contains(((bseVO1)code[1].get(i)).getClientAC()))
				flist.add(((bseVO1)code[1].get(i)).getClientAC());
		}
		
		for(int i=0;i<code[2].size();i++)
		{
			if(!flist.contains(((nsefoVO1)code[2].get(i)).getClientCode()))
				flist.add(((nsefoVO1)code[2].get(i)).getClientCode());
		}
					
		/*
		Set set = new HashSet<>();
		//System.out.println(code[0] + " " + code[1] + " " + code[2]);
		for(int i=0;i<code[0].size();i++)
		{
			fileVO1 fileVO = (fileVO1)code[0].get(i);
			String d[]=fileVO.getOrderEntryTime().split(" ");
			String date=d[0] + " " + d[1] + " " + d[2];
			//System.out.println(date.equals(mydate) + date + " " + mydate);
			//System.out.println(date + " " + mydate);
			if(date.equals(mydate) && !fileVO.getClientCode().equals("          ") && set.add(fileVO.getClientCode()))
			{
				//System.out.println( fileVO.getClientCode()+ " " + fileVO.getClientCode().length());		
				flist.add(fileVO.getClientCode().trim());
			}
		}
		for(int i=0;i<code[1].size();i++)
		{
			bseVO1 bseVO = (bseVO1)code[1].get(i);
			String d[]=bseVO.getTradeEntryDate().split("/");
			String date=d[2] + " " + d[1] + " " + d[0];
			//System.out.println(date.equals(mydate) + date + " " + mydate);
			if(date.equals(mydate) && !bseVO.getClientAC().equals("          ") && set.add(bseVO.getClientAC()))
			{
				//System.out.println(bseVO.getClientAC()+ " " + bseVO.getClientAC().length());
				flist.add(bseVO.getClientAC().trim());
			}
		}
		for(int i=0;i<code[2].size();i++)
		{
			nsefoVO1 nsefoVO = (nsefoVO1)code[2].get(i);
			String d[]=nsefoVO.getOrderEntryTime().split(" ");
			String date=d[0] + " " + d[1] + " " + d[2];
			//System.out.println(date.equals(mydate) + date + " " + mydate);
			if(date.equals(mydate) && !nsefoVO.getClientCode().equals("          ") && set.add(nsefoVO.getClientCode()))
			{
				//System.out.println( nsefoVO.getClientCode().length()+ " " + nsefoVO.getClientCode().length());
				flist.add(nsefoVO.getClientCode().trim());
			}
		}*/
		transaction.commit();
		session.close();
		System.out.println(flist);
		return flist;
	}

	public int insert(String filepath,String exchange,String date) {
		// TODO Auto-generated method stub
	
		System.out.println(filepath);
		String s="/";
		String s1="\\";
		System.out.println(s1);
		int flag=0;
		filepath=filepath.replace("\\", "/");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/office","root","root");
			Statement statement = connection.createStatement();
			
			if(exchange.equals("nse"))
			{
				statement.executeUpdate("load data infile '"+filepath+"' into table tempfilense fields terminated by ',' ignore 1 lines(TradeNo,TradeStatus,Symbol,Series,SecurityName,InstrumentType,BookType,MarketType,UserID,BranchID,BuySell,TradeQty,TradePrice,ProCli,ClientAC,ParticipantCode,AuctionPartType,AuctionNo,SettPeriod,TradeEntryDateTime,TradeModifyDateTime,OrderNo,CPId,ExchangeSegment,ClientCode,Alias,Remarks,ProductType,OrderTime,OrderEntryTime) set mydate='"+date+"' ");
				
				int d = statement.executeUpdate("delete tf.* from tempfilense tf inner join filense f on tf.TradeNo = f.TradeNo and f.mydate like '"+date+"' and f.BuySell = tf.BuySell");
				//select * from tempfilense inner join filense on tempfilense.TradeNo = filense.TradeNo 
				
				System.out.println(d + " inner join");
				
				ResultSet resultSet1 = statement.executeQuery("select * FROM tempfilense");
				resultSet1.last();
				int x = resultSet1.getRow();
				System.out.println(x + " count");
				
				if(d == 0)
					flag=statement.executeUpdate("load data infile '"+filepath+"' into table filense fields terminated by ',' ignore 1 lines(TradeNo,TradeStatus,Symbol,Series,SecurityName,InstrumentType,BookType,MarketType,UserID,BranchID,BuySell,TradeQty,TradePrice,ProCli,ClientAC,ParticipantCode,AuctionPartType,AuctionNo,SettPeriod,TradeEntryDateTime,TradeModifyDateTime,OrderNo,CPId,ExchangeSegment,ClientCode,Alias,Remarks,ProductType,OrderTime,OrderEntryTime) set mydate='"+date+"' ");
				else if(x!=0)
					flag=statement.executeUpdate("insert into filense(TradeNo,TradeStatus,Symbol,Series,SecurityName,InstrumentType,BookType,MarketType,UserID,BranchID,BuySell,TradeQty,TradePrice,ProCli,ClientAC,ParticipantCode,AuctionPartType,AuctionNo,SettPeriod,TradeEntryDateTime,TradeModifyDateTime,OrderNo,CPId,ExchangeSegment,ClientCode,Alias,Remarks,ProductType,OrderTime,OrderEntryTime,mydate) select TradeNo,TradeStatus,Symbol,Series,SecurityName,InstrumentType,BookType,MarketType,UserID,BranchID,BuySell,TradeQty,TradePrice,ProCli,ClientAC,ParticipantCode,AuctionPartType,AuctionNo,SettPeriod,TradeEntryDateTime,TradeModifyDateTime,OrderNo,CPId,ExchangeSegment,ClientCode,Alias,Remarks,ProductType,OrderTime,OrderEntryTime,mydate FROM tempfilense");
				else
					flag=0;
				statement.executeUpdate("truncate table tempfilense");
				resultSet1.close();
				
			}
			else if(exchange.equals("bse"))
			{
				statement.executeUpdate("load data infile '"+filepath+"' into table tempfilebse fields terminated by '|' ignore 1 lines(ScripCode,Symbol,TradeNo,Price,TradedQty,BrokerId,Reserved,TradeEntryTime,TradeEntryDate,ClientId,BuySell,TransactionType,OrderNumber,CAClass,ISIN,ClientAC,NewClient,Remarks,ISIN1,SecuritySeries,SettlementNo,ProductType,OrderModifyTime,OrderEntryTime,DealerCode,PreOpen,SPPreOpen,Blank) set mydate='"+date+"' ");
				
				int d = statement.executeUpdate("delete tf.* from tempfilebse tf inner join filebse f on tf.TradeNo = f.TradeNo and f.mydate like '"+date+"' and f.BuySell = tf.BuySell");
				
				System.out.println(d + "inner join");
				
				ResultSet resultSet1 = statement.executeQuery("select * from tempfilebse");
				resultSet1.last();
				int x = resultSet1.getRow();
				
				if(d == 0)
					flag=statement.executeUpdate("load data infile '"+filepath+"' into table filebse fields terminated by '|' ignore 1 lines(ScripCode,Symbol,TradeNo,Price,TradedQty,BrokerId,Reserved,TradeEntryTime,TradeEntryDate,ClientId,BuySell,TransactionType,OrderNumber,CAClass,ISIN,ClientAC,NewClient,Remarks,ISIN1,SecuritySeries,SettlementNo,ProductType,OrderModifyTime,OrderEntryTime,DealerCode,PreOpen,SPPreOpen,Blank) set mydate='"+date+"' ");
				else if(x!=0)
					flag=statement.executeUpdate("insert into filebse(ScripCode,Symbol,TradeNo,Price,TradedQty,BrokerId,Reserved,TradeEntryTime,TradeEntryDate,ClientId,BuySell,TransactionType,OrderNumber,CAClass,ISIN,ClientAC,NewClient,Remarks,ISIN1,SecuritySeries,SettlementNo,ProductType,OrderModifyTime,OrderEntryTime,DealerCode,PreOpen,SPPreOpen,Blank,mydate) select ScripCode,Symbol,TradeNo,Price,TradedQty,BrokerId,Reserved,TradeEntryTime,TradeEntryDate,ClientId,BuySell,TransactionType,OrderNumber,CAClass,ISIN,ClientAC,NewClient,Remarks,ISIN1,SecuritySeries,SettlementNo,ProductType,OrderModifyTime,OrderEntryTime,DealerCode,PreOpen,SPPreOpen,Blank,mydate from tempfilebse");
				else
					flag=0;
				statement.executeUpdate("truncate table tempfilebse");
			
				resultSet1.close();
				
			}
			else if(exchange.equals("nsefo"))
			{
				statement.executeUpdate("load data infile '"+filepath+"' into table tempfilensefo fields terminated by ',' ignore 1 lines(TradeNo,TradeStatus,InstrumentName,Symbol,ExpiryDate,StrikePrice,OptionType,SecurityName,BookType,BookTypeName,MarketType,UserID,BranchID,BuySell,QtyTraded,Price,ProCli,ClientAC,ParticipantCode,OpenClose,CoverUnCover,EntryTime,ModifyDateTime,OrderNo,CPId,ExchangeSegment,ClientCode,Alias,Remarks,OrderTime,OrderEntryTime,ProductType,LegIndicator) set mydate='"+date+"' ");
				
				int d = statement.executeUpdate("delete tf.* from tempfilensefo tf inner join filensefo f on tf.TradeNo = f.TradeNo and f.mydate like '"+date+"' and f.BuySell = tf.BuySell");
				
				System.out.println(d+ "inner join");
				
				ResultSet resultSet1 = statement.executeQuery("select * from tempfilensefo");
				resultSet1.last();
				int x = resultSet1.getRow();
				
				if(d == 0)
					flag=statement.executeUpdate("load data infile '"+filepath+"' into table filensefo fields terminated by ',' ignore 1 lines(TradeNo,TradeStatus,InstrumentName,Symbol,ExpiryDate,StrikePrice,OptionType,SecurityName,BookType,BookTypeName,MarketType,UserID,BranchID,BuySell,QtyTraded,Price,ProCli,ClientAC,ParticipantCode,OpenClose,CoverUnCover,EntryTime,ModifyDateTime,OrderNo,CPId,ExchangeSegment,ClientCode,Alias,Remarks,OrderTime,OrderEntryTime,ProductType,LegIndicator) set mydate='"+date+"' ");
				else if(x !=0)
					flag=statement.executeUpdate("insert into filensefo(TradeNo,TradeStatus,InstrumentName,Symbol,ExpiryDate,StrikePrice,OptionType,SecurityName,BookType,BookTypeName,MarketType,UserID,BranchID,BuySell,QtyTraded,Price,ProCli,ClientAC,ParticipantCode,OpenClose,CoverUnCover,EntryTime,ModifyDateTime,OrderNo,CPId,ExchangeSegment,ClientCode,Alias,Remarks,OrderTime,OrderEntryTime,ProductType,LegIndicator,mydate) select TradeNo,TradeStatus,InstrumentName,Symbol,ExpiryDate,StrikePrice,OptionType,SecurityName,BookType,BookTypeName,MarketType,UserID,BranchID,BuySell,QtyTraded,Price,ProCli,ClientAC,ParticipantCode,OpenClose,CoverUnCover,EntryTime,ModifyDateTime,OrderNo,CPId,ExchangeSegment,ClientCode,Alias,Remarks,OrderTime,OrderEntryTime,ProductType,LegIndicator,mydate from tempfilensefo");
				else 
					flag=0;
				
				statement.executeUpdate("truncate table tempfilensefo");
				
				resultSet1.close();
				
			}
			
			connection.close();
			statement.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
		
		
		
	}

public int checkcolumn(String filepath, String ex) throws IOException {
	// TODO Auto-generated method stub
	
	String nsecol[] = {"Trade No","Trade Status","Symbol","Series","Security Name","Instrument Type","Book Type","Market Type","User ID","Branch ID","BuySell","Trade Qty","Trade Price","Pro/Cli","Client A/C","Participant Code","Auction Part Type","Auction No","Sett. Period","Trade Entry DateTime","Trade Modify DateTime","Order No","CP Id","Exchange Segment","Client Code","Alias","Remarks","Product Type","Order Time","Order Entry Time"};
	String bsecol[] = {"Scrip Code","Symbol","Trade No","Price","Traded Qty","Broker Id","Reserved","Trade Entry Time","Trade Entry Date","Client Id","Buy Sell","Transaction Type","Order Number","CA Class","ISIN","Client AC","New Client","Remarks","ISIN1","Security Series","Settlement No","Product Type","Order Modify Time","Order Entry Time","Dealer Code","PreOpen","SPPreOpen"};
	String nsefocol[] = {"Trade No","Trade Status","Instrument Name","Symbol","Expiry Date","Strike Price","Option Type","Security Name","Book Type","Book Type Name","Market Type","User ID","Branch ID","BuySell","Qty Traded","Price","Pro/Cli","Client AC","Participant Code","Open Close","Cover UnCover","Entry Time","Modify DateTime","Order No","CP Id","Exchange Segment","Client Code","Alias","Remarks","Order Time","Order Entry Time","ProductType","LegIndicator"};
	
	File f = new File(filepath);
	FileReader fr = new FileReader(f);
	BufferedReader br = new BufferedReader(fr);
	int flag=0;
	if(ex.equals("nse"))
	{
		String columns[] = br.readLine().split(",");
		List ls = new ArrayList<>();
		
		for(int i=0;i<nsecol.length;i++)
		{
			//System.out.println(columns[i]);
			ls.add(nsecol[i]);
		}
		
		for(int i=0;i<columns.length;i++)
		{
			if(!ls.contains(columns[i]))
			{
				flag=1;
				break;
			}
		}
		
	}
	else if(ex.equals("bse"))
	{
		String x = br.readLine();
		String columns[] = x.split("\\|");
		//System.out.println(x);
		List ls = new ArrayList<>();
		
		for(int i=0;i<bsecol.length;i++)
		{
			//System.out.println(columns[i]);
			ls.add(bsecol[i]);
		}
	
		for(int i=0;i<columns.length;i++)
		{
			if(!ls.contains(columns[i]))
			{
				flag=1;
				break;
			}
		}
	}
	else if(ex.equals("nsefo"))
	{
		String columns[] = br.readLine().split(",");
		List ls = new ArrayList<>();
		
		for(int i=0;i<nsefocol.length;i++)
		{
			//System.out.println(columns[i]);
			ls.add(nsefocol[i]);
		}
	
		for(int i=0;i<columns.length;i++)
		{
			if(!ls.contains(columns[i]))
			{
				flag=1;
				break;
			}
		}
	}
	
	
	
	
	br.close();
	return flag;
}

	
}
