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

public class servicesProducts implements ServicesProductsInter
{
	DaoProductsInter daoProducts = new daoProducts();
	//function to read text from products file. returns list of objects of domainProducts
	public List<domainProducts> readCSV(String filepath) throws FileNotFoundException
	{
		//file reading
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		
		//add objects of domainProducts into list
		List<domainProducts> domainProdsList ;
		domainProdsList = new ArrayList<domainProducts>();
		String line;
		try
		{
			while((line=reader.readLine())!=null)
			{
				if(line.charAt(0)=='#')
					continue;
				domainProducts dProds = new domainProducts();	
	        	String[] str = line.split(",");
	        	dProds.setProdId(Integer.parseInt(str[0]));
	        	dProds.setProdName(str[1]);
	        	dProds.setProdQty(Integer.parseInt(str[2]));
	        	dProds.setProdUp(Integer.parseInt(str[3]));
	        	domainProdsList.add(dProds);
			}
			reader.close();
			return domainProdsList;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return domainProdsList;
	}
	
	//function to save product into products table in database
	public void saveToDb(domainProducts dProds) throws ClassNotFoundException, SQLException
	{
		//check if product already exists in products table 
		if(!daoProducts.ifExists(dProds))
		{
			daoProducts.saveToDB(dProds);
		}
		else
		{
			updateOnDb(dProds,3,daoProducts.getProduct(dProds.getProdId()).getProdQty()+dProds.getProdQty());
			System.out.println("Products already existing");
		}
	}
	
	//function to delete a product from products table 
	public void deleteFromDb(domainProducts dProds) throws ClassNotFoundException, SQLException
	{
		//check if product already exists in products table 
		if(daoProducts.ifExists(dProds))
		{
			daoProducts.deleteFromDB(dProds);
		}
		else
		{
			System.out.println("Product not present");
		}
	}
	
	//function to update value in products table in database 
	public void updateOnDb(domainProducts dProds, int colIdentifier, String value) throws ClassNotFoundException, SQLException
	{
		//check if product already exists in products table 
		if(daoProducts.ifExists(dProds))
		{
			//provide column name and new value of the column to updateOnDB() function
			String[] colIdentifierList = {"prod_id","prod_name","prod_qty","prod_unit_price"};
			daoProducts.updateOnDB(dProds, colIdentifierList[colIdentifier-1], value);
		}
		else
		{
			System.out.println("Product not present");
		}
	}
	public void updateOnDb(domainProducts dProds, int colIdentifier, int value) throws ClassNotFoundException, SQLException
	{
		//check if product already exists in products table 
		if(daoProducts.ifExists(dProds))
		{
			//provide column name and new value of the column to updateOnDB() function
			String[] colIdentifierList = {"prod_id","prod_name","prod_qty","prod_unit_price"};
			daoProducts.updateOnDB(dProds, colIdentifierList[colIdentifier-1], value);
		}
		else
		{
			System.out.println("Product not present");
		}
	}
}
