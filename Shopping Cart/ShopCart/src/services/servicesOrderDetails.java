package services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import dao.*;
import domain.*;

public class servicesOrderDetails implements ServicesOrderDetailsInter
{
	DaoUsersInter daoUsers = new daoUsers();
	DaoOrderDetailsInter daoOrderDetails = new daoOrderDetails();
	DaoProductsInter daoProducts = new daoProducts();
	DaoOrdersInter daoOrders = new daoOrders();
	
	//function to generate invoice and output to a CSV file in "<project's home>/res/" directory
	public void generateInvoice(int order_id) throws ClassNotFoundException, SQLException, IOException
	{	
		//giving order_id to getOrders() function which returns list of objects of domainOrderDetails
		List<domainOrderDetails> dOrderList = daoOrderDetails.getOrders(order_id);
		
		
		//getting user_id from orders table corresponding to the order_id
		int user_id = daoOrders.getUser(order_id); 
		//getting object of domainUsers by giving user_id to getUser() function 
		domainUsers dUser = daoUsers.getUser(user_id);
		
		
		//creating CSV file with initial values like order ID, date, User name, User address etc. 
		Date date = new Date();
		File file = new File("res/Invoice.csv");
		try { file.createNewFile(); }
		catch (Exception e) { e.printStackTrace(); }
		FileWriter fWrite = new FileWriter(file);
		fWrite.write("Order ID- "+order_id+",,,,Date- "+date.toString()+"\n");
		fWrite.write("Name: "+dUser.getUserName()+"\nAddress: "+dUser.getUserAdd()+"\n");
		fWrite.write("Sr. no,Product code,Product Name,Quantity,Price,Net Price\n");
		
		
		//core logic to get product details from products table >> calculate total amount >> print everything to CSV  
		int grandTotal=0;
		for(int i=0 ; i< dOrderList.size() ;i++)
		{
			domainProducts dProd = daoProducts.getProduct(dOrderList.get(i).getProdId());
			int qty = dOrderList.get(i).getProdQty();
			int unitPrice = dProd.getProdUp();
			fWrite.write((i+1)+","+dProd.getProdId()+","+dProd.getProdName()+","+qty+","+unitPrice+","+(qty*unitPrice)+"\n");
			grandTotal = grandTotal + (qty*unitPrice);	
		}
		fWrite.write(",,,,Total Price,"+grandTotal);
		fWrite.flush();
		fWrite.close();
	}
	
	
	//function to update the quantity of a product into products table. return 0 if stock is not available else returns 1
	public int updateQty(domainOrderDetails dOrderDetails) throws ClassNotFoundException, SQLException
	{
		
		int qty = daoProducts.getQty(dOrderDetails);
		domainProducts dProds = new domainProducts();
		dProds.setProdId(dOrderDetails.getProdId());
		if(qty!=0)
		{
			if(qty - dOrderDetails.getProdQty()>=0)
			{
				daoProducts.updateQty(dProds, "prod_qty", qty-dOrderDetails.getProdQty());
			}
			else if (qty - dOrderDetails.getProdQty()<0)
			{
				daoProducts.updateQty(dProds, "prod_qty", 0);
				dOrderDetails.setProdQty(qty);
			}
			return 1;
		}
		else
		{
			System.out.println(dProds.getProdName()+" : item out of stock");
			return 0;
		}
	}
	
	
	//function to save the order details into orderDetails table 
	public void saveToDb(domainOrderDetails dOrderDetails, int order_id) throws ClassNotFoundException, SQLException
	{
		//checking if the order already exists in orderDetails table
		//function ifExists() returns -1 if particular order not existing in the orderDetails table
		//else returns the existing quantity of order in the orderDetails table
		int qty = daoOrderDetails.ifExists(dOrderDetails, order_id);
		if(qty == -1)
		{
			//save the orderDetails to database
			daoOrderDetails.saveToDB(dOrderDetails, order_id);
		}
		else
		{
			//updating orderDetails table with new quantity added with existing quantity
			System.out.println("already added to cart, updating quantity");
			dOrderDetails.setProdQty(qty + dOrderDetails.getProdQty());
			daoOrderDetails.updateOnDB(dOrderDetails, order_id);
		}
	}
}