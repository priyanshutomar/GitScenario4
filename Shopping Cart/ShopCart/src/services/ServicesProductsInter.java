package services;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import domain.domainProducts;

public interface ServicesProductsInter {
	public List<domainProducts> readCSV(String filepath) throws FileNotFoundException;
	public void saveToDb(domainProducts dProds) throws ClassNotFoundException, SQLException;
	public void deleteFromDb(domainProducts dProds) throws ClassNotFoundException, SQLException;
	public void updateOnDb(domainProducts dProds, int colIdentifier, String value) throws ClassNotFoundException, SQLException;
	public void updateOnDb(domainProducts dProds, int colIdentifier, int value) throws ClassNotFoundException, SQLException;
}
