package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.*;

public class daoOrderDetails implements DaoOrderDetailsInter
{
	
	public void saveToDB(domainOrderDetails dOrderDetails, int order_id) throws ClassNotFoundException, SQLException
	{

		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		try
		{
			System.out.println("insert into orderdetails VALUES ("+order_id+", "+dOrderDetails.getProdId()+",'"+dOrderDetails.getProdQty()+"')");
			s1.execute("insert into orderdetails VALUES ("+order_id+", "+dOrderDetails.getProdId()+",'"+dOrderDetails.getProdQty()+"')");
			System.out.println("saved to database successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		conn.close();
	}
	
	public List<domainOrderDetails> getOrders(int order_id) throws ClassNotFoundException, SQLException
	{
		//create connection
		List<domainOrderDetails> dOrderList = new ArrayList<domainOrderDetails>();
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		System.out.println("select * from orderdetails WHERE order_id = "+order_id);
		ResultSet rst = s1.executeQuery("select * from orderdetails WHERE order_id = "+order_id);
		while(rst.next())
		{
			domainOrderDetails dOrderDetails = new domainOrderDetails();
			dOrderDetails.setProdId(rst.getInt(2));
			dOrderDetails.setProdQty(rst.getInt(3));
			dOrderList.add(dOrderDetails);
		}
		conn.close();
		return dOrderList;	
	}
	
	public int ifExists(domainOrderDetails dOrderDetails, int order_id) throws ClassNotFoundException, SQLException
	{
		//create connection
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		System.out.println("select * from orderdetails WHERE prod_id = "+dOrderDetails.getProdId()+" AND order_id = "+order_id);
		ResultSet rst = s1.executeQuery("select * from orderdetails WHERE prod_id = "+dOrderDetails.getProdId()+" AND order_id = "+order_id);
		if(rst.next())
		{
			int temp = rst.getInt(3);
			conn.close();
			return temp;
		}
		conn.close();
		return -1;
	}
	
	public void updateOnDB(domainOrderDetails dOrderDetails, int order_id) throws ClassNotFoundException, SQLException
	{
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		try
		{
			System.out.println("UPDATE orderdetails SET prod_qty = "+dOrderDetails.getProdQty()+" WHERE prod_id = "+dOrderDetails.getProdId()+" AND order_id = "+order_id);
			s1.execute("UPDATE orderdetails SET prod_qty = "+dOrderDetails.getProdQty()+" WHERE prod_id = "+dOrderDetails.getProdId()+" AND order_id = "+order_id);
			System.out.println("saved to database successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		conn.close();
	}
	
	public Connection createConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/shopCart", "root", "password");
		return conn;
	}
}
