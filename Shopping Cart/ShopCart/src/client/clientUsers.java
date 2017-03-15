package client;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import domain.*;
import services.*;

public class clientUsers
{
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, SQLException
	{
		ServicesUsersInter servicesUsers = new servicesUsers();
		try
		{
			//input list of users from usersInput text file
			String filePath = "res/usersInput.csv";
			List<domainUsers> usersData = servicesUsers.readCSV(filePath);
			
			//saving to database
			for(int i=0 ; i< usersData.size() ;i++)
			{
				servicesUsers.saveToDb(usersData.get(i));
			}
			
			//update operation on database
			servicesUsers.updateOnDb(usersData.get(4),2,"Hank Schrader");
			
			//delete operation on database
			servicesUsers.deleteFromDb(usersData.get(3));
		}
		catch(Exception e)
		{
			System.out.println("Unknown exception occurred : "+e+"\nAbnormal termination");
		}
	}
}
