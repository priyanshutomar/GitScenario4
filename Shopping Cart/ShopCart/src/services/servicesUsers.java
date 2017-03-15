package services;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.*;
import domain.*;

public class servicesUsers implements ServicesUsersInter
{
	DaoUsersInter daoUsers = new daoUsers();
	//function to read text from users file. returns list of objects of domainUsers
	public List<domainUsers> readCSV(String filepath) throws FileNotFoundException
	{
		//file reading
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		
		//add objects of domainUsers in list
		List<domainUsers> domainUsersList ;
		domainUsersList = new ArrayList<domainUsers>();
		String line;
		try
		{
			while((line=reader.readLine())!=null)
			{
				if(line.charAt(0)=='#')
					continue;
				domainUsers dUsers = new domainUsers();	
	        	String[] str = line.split(",");
	        	dUsers.setUserId(Integer.parseInt(str[0]));
	        	dUsers.setUserName(str[1]);
	        	dUsers.setUserAdd(str[2]);
	        	domainUsersList.add(dUsers);
			}
			reader.close();
			return domainUsersList;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return domainUsersList;
	}
	
	//function to save users into users table in database
	public void saveToDb(domainUsers dUsers) throws ClassNotFoundException, SQLException
	{
		//check if product already exists in users table 
		if(!daoUsers.ifExists(dUsers))
		{
			daoUsers.saveToDB(dUsers);
		}
		else
		{
			System.out.println("User already existing");
		}
	}
	
	//function to delete a user from users table 
	public void deleteFromDb(domainUsers dUsers) throws ClassNotFoundException, SQLException
	{
		//check if user already exists in users table 
		if(daoUsers.ifExists(dUsers))
		{
			daoUsers.deleteFromDB(dUsers);
		}
		else
		{
			System.out.println("User already not existing");
		}
	}
	
	//function to update value in users table in database
	public void updateOnDb(domainUsers dUsers, int colIdentifier, String value) throws ClassNotFoundException, SQLException
	{
		//check if user already exists in products table 
		if(daoUsers.ifExists(dUsers))
		{
			//provide column name and new value of the column to updateOnDB() function
			String[] colIdentifierList = {"user_id","user_name","user_add"};
			daoUsers.updateOnDB(dUsers, colIdentifierList[colIdentifier-1], value);
		}
		else
		{
			System.out.println("User already not existing");
		}
	}
	
}
