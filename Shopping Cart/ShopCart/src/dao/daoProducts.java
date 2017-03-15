package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import domain.*;

public class daoProducts implements DaoProductsInter
{
	
	public domainProducts getProduct(int prod_id) throws ClassNotFoundException, SQLException
	{
		//create connection
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		System.out.println("select * from products WHERE prod_id = "+prod_id);
		ResultSet rst = s1.executeQuery("select * from products WHERE prod_id = "+prod_id);
		rst.next();
		domainProducts dProds = new domainProducts();
		dProds.setProdId(rst.getInt(1));
		dProds.setProdName(rst.getString(2));
		dProds.setProdQty(rst.getInt(3));
		dProds.setProdUp(rst.getInt(4));
		conn.close();
		return dProds;
	}
	
	public void saveToDB(domainProducts dProds) throws ClassNotFoundException, SQLException
	{
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		try
		{
			//s1.execute("insert into users VALUES (3,'jesse','albequerque')");
			s1.execute("insert into products VALUES ("+dProds.getProdId()+",'"+dProds.getProdName()+"',"+dProds.getProdQty()+", "+dProds.getProdUp()+")");
			System.out.println("saved to database successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		conn.close();
	}
	public void updateOnDB(domainProducts dProds, String colName, String value) throws ClassNotFoundException, SQLException
	{
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		try
		{
			//s1.execute("insert into users VALUES (3,'jesse','albequerque')");
			System.out.println("UPDATE products SET "+colName+" = '"+value+"' WHERE prod_id = "+dProds.getProdId());
			s1.execute("UPDATE products SET "+colName+" = '"+value+"' WHERE prod_id = "+dProds.getProdId());
			System.out.println("saved to database successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		conn.close();
	}
	public void updateOnDB(domainProducts dProds, String colName, int value) throws ClassNotFoundException, SQLException
	{
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		try
		{
			//s1.execute("insert into users VALUES (3,'jesse','albequerque')");
			System.out.println("UPDATE products SET "+colName+" = '"+value+"' WHERE prod_id = "+dProds.getProdId());
			s1.execute("UPDATE products SET "+colName+" = '"+value+"' WHERE prod_id = "+dProds.getProdId());
			System.out.println("saved to database successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		conn.close();
	}
	public void updateQty(domainProducts dProds, String colName, int value) throws ClassNotFoundException, SQLException
	{
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		try
		{
			//s1.execute("insert into users VALUES (3,'jesse','albequerque')");
			System.out.println("UPDATE products SET "+colName+" = "+value+" WHERE prod_id = "+dProds.getProdId());
			s1.execute("UPDATE products SET "+colName+" = "+value+" WHERE prod_id = "+dProds.getProdId());
			System.out.println("saved to database successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		conn.close();
	}
	
	public void deleteFromDB(domainProducts dProds) throws ClassNotFoundException, SQLException
	{
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		try
		{
			//s1.execute("insert into users VALUES (3,'jesse','albequerque')");
			//s1.execute("insert into users VALUES ("+dUsers.getUserId()+",'"+dUsers.getUserName()+"','"+dUsers.getUserAdd()+"')");
			s1.executeUpdate("DELETE FROM products WHERE prod_id = "+dProds.getProdId());
			System.out.println("product deleted from database successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		conn.close();
	}
	public boolean ifExists(domainProducts dProds) throws ClassNotFoundException, SQLException
	{
		//create connection
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		ResultSet rst = s1.executeQuery("select * from products");
		while(rst.next())
		{
			if(rst.getInt(1) == dProds.getProdId())
			{
				conn.close();
				return true;
			}
		}
		conn.close();
		return false;
	}
	
	public int getQty(domainOrderDetails dOrderDetails) throws ClassNotFoundException, SQLException
	{
		//create connection
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		ResultSet rst = s1.executeQuery("select * from products WHERE prod_id = "+dOrderDetails.getProdId());
		if(rst.next())
		{

			int temp = rst.getInt(3);
			conn.close();
			return temp;
		}
		else
		{
			System.out.println("Product not available");
			conn.close();
			return 0;
		}
	}
	
	public Connection createConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/shopCart", "root", "password");
		return conn;
	}
}
