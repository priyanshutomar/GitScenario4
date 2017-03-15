package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.*;

public class daoUsers implements DaoUsersInter
{
	
	public domainUsers getUser(int user_id) throws ClassNotFoundException, SQLException
	{
		//create connection
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		System.out.println("select * from users WHERE user_id = "+user_id);
		ResultSet rst = s1.executeQuery("select * from users WHERE user_id = "+user_id);
		if(rst.next())
		{
			domainUsers dUser = new domainUsers();
			dUser.setUserId(rst.getInt(1));
			dUser.setUserName(rst.getString(2));
			dUser.setUserAdd(rst.getString(3));
			conn.close();
			return dUser;
		}
		else
		{
			return null;
		}
	}
	
	public void saveToDB(domainUsers dUsers) throws ClassNotFoundException, SQLException
	{
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		try
		{
			//s1.execute("insert into users VALUES (3,'jesse','albequerque')");
			s1.execute("insert into users VALUES ("+dUsers.getUserId()+",'"+dUsers.getUserName()+"','"+dUsers.getUserAdd()+"')");
			System.out.println("saved to database successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		conn.close();
	}
	
	public void updateOnDB(domainUsers dUsers, String colName, String value) throws ClassNotFoundException, SQLException
	{
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		try
		{
			System.out.println("UPDATE users SET "+colName+" = '"+value+"' WHERE user_id = "+dUsers.getUserId());
			s1.execute("UPDATE users SET "+colName+" = '"+value+"' WHERE user_id = "+dUsers.getUserId());
			System.out.println("saved to database successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		conn.close();
	}
	
	public void deleteFromDB(domainUsers dUsers) throws ClassNotFoundException, SQLException
	{
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		try
		{
			//s1.execute("insert into users VALUES (3,'jesse','albequerque')");
			//s1.execute("insert into users VALUES ("+dUsers.getUserId()+",'"+dUsers.getUserName()+"','"+dUsers.getUserAdd()+"')");
			s1.executeUpdate("DELETE FROM users WHERE user_id = "+dUsers.getUserId());
			System.out.println("user deleted from database successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		conn.close();
	}
	
	public boolean ifExists(domainUsers dUsers) throws ClassNotFoundException, SQLException
	{
		//create connection
		Connection conn = createConnection();
		Statement s1 = conn.createStatement();
		ResultSet rst = s1.executeQuery("select * from users");
		while(rst.next())
		{
			if(rst.getInt(1) == dUsers.getUserId())
			{
				conn.close();
				return true;
			}
		}
		conn.close();
		return false;
	}
	
	public Connection createConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/shopCart", "root", "password");
		return conn;
	}
}
