package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import domain.*;

public class daoOrders implements DaoOrdersInter
{
	
	public int getUser(int order_id) throws SQLException, ClassNotFoundException
	{
		//create connection
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		ResultSet rst = s1.executeQuery("select * from orders WHERE order_id ="+order_id);
		rst.next();
		return rst.getInt(2);
	}
	
	
	public void saveToDB(domainOrders dOrders, int order_id) throws ClassNotFoundException, SQLException
	{
		Date date = new Date();
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		try
		{
			//s1.execute("insert into users VALUES (3,'jesse','albequerque')");
			System.out.println("insert into orders VALUES ("+order_id+", "+dOrders.getUserId()+",'"+date.toString()+"')");
			s1.execute("insert into orders VALUES ("+order_id+", "+dOrders.getUserId()+",'"+date.toString()+"')");
			System.out.println("saved to database successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		conn.close();
	}
	
	public void updateDB(domainOrders dOrders) throws ClassNotFoundException, SQLException
	{
		Date date = new Date();
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		try
		{
			System.out.println("UPDATE orders SET order_date = '"+date.toString()+"' WHERE user_id = "+dOrders.getUserId());
			s1.execute("UPDATE orders SET order_date = '"+date.toString()+"' WHERE user_id = "+dOrders.getUserId());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		conn.close();
	}

	public int ifExists(domainOrders dOrders) throws ClassNotFoundException, SQLException
	{
		//create connection
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		ResultSet rst = s1.executeQuery("select * from orders");
		while(rst.next())
		{
			if(rst.getInt(2) == dOrders.getUserId())
			{
				int temp = rst.getInt(1);
				conn.close();
				return temp;
			}
		}
		conn.close();
		return -1;
	}
	
	public Connection createConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/shopCart", "root", "password");
		return conn;
	}
}
