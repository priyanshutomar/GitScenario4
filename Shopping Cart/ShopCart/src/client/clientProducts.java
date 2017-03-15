package client;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import domain.*;
import services.*;

public class clientProducts
{
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, SQLException
	{
		ServicesProductsInter servicesProducts = new services.servicesProducts();
		try
		{
			//reading products catalog from productsInput text file
			String filePath = "res/productsInput.csv";
			List<domainProducts> prodsData = servicesProducts.readCSV(filePath);
			
			//saving products to products database
			for(int i=0 ; i< prodsData.size() ;i++)
			{
				servicesProducts.saveToDb(prodsData.get(i));
			}
			
			//update operation on database
			servicesProducts.updateOnDb(prodsData.get(4),2,"Ricin (with capsule)");
			
			//delete operation on database
			servicesProducts.deleteFromDb(prodsData.get(3));
		}
		catch(Exception e)
		{
			System.out.println("Unknown exception occurred : "+e+"\nAbnormal termination");
		}
	}
}
