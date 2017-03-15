package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.beans.MainPOJO;
import com.utils.*;

public class Dao implements DaoInter{
	public void CreateSubsription(MainPOJO pojo) throws ClassNotFoundException, SQLException
	{
		Connection conn = new Utils().createConnection();
		Statement s1 = conn.createStatement();
		try
		{
			s1.execute("insert into createsub (fname, lname, uuid, accountidentifier) VALUES ('"+pojo.getCreator().getFirstName()+"','"+pojo.getCreator().getLastName()+"','"+pojo.getCreator().getUuid()+"','"+pojo.getCreator().getFirstName()+":"+pojo.getCreator().getUuid()+"')");
			System.out.println("saved to database successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		conn.close();
	}
	
	public void CancelSubscription(MainPOJO pojo) throws ClassNotFoundException, SQLException
	{
		Connection conn = new Utils().createConnection();
		Statement s1 = conn.createStatement();
		try
		{
			s1.executeUpdate("DELETE FROM createsub WHERE accountidentifier = '"+pojo.getCreator().getFirstName()+":"+pojo.getCreator().getUuid()+"'");
			System.out.println("user deleted from database successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		conn.close();
	}
	
	public boolean IfExists(MainPOJO pojo) throws ClassNotFoundException, SQLException
	{
		//create connection
		Connection conn = new Utils().createConnection();
		Statement s1 = conn.createStatement();
		ResultSet rst = s1.executeQuery("select * from createsub WHERE accountidentifier = '"+pojo.getCreator().getFirstName()+":"+pojo.getCreator().getUuid()+"'");
		if(rst.next())
		{
			if( (rst.getString(2)).equalsIgnoreCase( pojo.getCreator().getFirstName()) )
			{
				conn.close();
				return true;
			}
		}
		conn.close();
		return false;
	}

	public boolean getAccountIdentifier(MainPOJO pojo) throws ClassNotFoundException, SQLException {
		Connection conn = new Utils().createConnection();
		Statement s1 = conn.createStatement();
		ResultSet rst = s1.executeQuery("select * from createsub WHERE accountidentifier = '"+pojo.getPayload().getAccount().getAccountIdentifier()+"'");
		if(rst.next())
		{
			conn.close();
			return true;
		}
		conn.close();
		return false;
	}
	
	
}
