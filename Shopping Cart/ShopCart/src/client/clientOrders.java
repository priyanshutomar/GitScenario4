package client;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import domain.*;
import services.*;

public class clientOrders
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException
	{
		ServicesOrderDetailsInter servicesOrderDetails = new servicesOrderDetails();
		ServicesOrdersInter servicesOrders = new servicesOrders();
		servicesOrders orderID = new servicesOrders();
		try
		{
			//input orders list from orderInput text file
			String filePath = "res/orderInput.csv";
			List<domainOrderDetails> orderDetailsData = servicesOrders.readCSV(filePath);
			
			//updating quantities of products and saving to database 
			for(int i=0 ; i< orderDetailsData.size() ;i++)
			{
				if(1==servicesOrderDetails.updateQty(orderDetailsData.get(i)))
				{
					servicesOrderDetails.saveToDb(orderDetailsData.get(i),orderID.order_id);
				}
				else
				{
					System.out.println("Failed to place the order");
				}
			}
			
			//Invoice generation and saving to Invoice.csv file in "<project's home>/res/" directory of project
			servicesOrderDetails.generateInvoice(orderID.order_id);
		}
		catch(Exception e)
		{
			System.out.println("Unknown exception occurred : "+e+"\nAbnormal termination");
			e.printStackTrace();
		}
	}	
}
