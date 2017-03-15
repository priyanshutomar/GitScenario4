package services;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.*;
import domain.*;

public class servicesOrders implements ServicesOrdersInter
{
	DaoOrdersInter daoOrders = new daoOrders();
	public static int order_id;
	
	//function to read text from orders file. returns list of objects of domainOrderDetails
	public List<domainOrderDetails> readCSV(String filepath) throws IOException, ClassNotFoundException, SQLException
	{
		//file reading
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		
		//read user_id and check if user already have some orders or not 
		String user = reader.readLine();
		while(user.charAt(0)=='#')
		{
			user = reader.readLine();
		}
		String[] str1 = user.split(",");
		domainOrders dOrders = new domainOrders();
		dOrders.setUserId(Integer.parseInt(str1[0]));
		order_id = daoOrders.ifExists(dOrders);
		if(order_id == -1)
		{	
			order_id = Integer.parseInt(str1[1]);
			daoOrders.saveToDB(dOrders, order_id);
		}
		else
		{
			daoOrders.updateDB(dOrders);
		}
		
		//read orders and create list of objects of orderDetails
		List<domainOrderDetails> domainOrderDetailsList ;
		domainOrderDetailsList = new ArrayList<domainOrderDetails>();
		String line;
		try
		{
			while((line=reader.readLine())!=null)
			{
				if(line.charAt(0)=='#')
					continue;
				domainOrderDetails dOrderDetails = new domainOrderDetails();
	        	String[] str2 = line.split(",");
	        	dOrderDetails.setProdId(Integer.parseInt(str2[0]));
	        	dOrderDetails.setProdQty(Integer.parseInt(str2[1]));
	        	domainOrderDetailsList.add(dOrderDetails);
			}
			reader.close();
			return domainOrderDetailsList;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return domainOrderDetailsList;
	}
}
