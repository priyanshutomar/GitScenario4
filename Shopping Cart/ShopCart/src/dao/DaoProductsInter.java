package dao;

import java.sql.Connection;
import java.sql.SQLException;

import domain.domainOrderDetails;
import domain.domainProducts;

public interface DaoProductsInter {
	public domainProducts getProduct(int prod_id) throws ClassNotFoundException, SQLException;
	public void saveToDB(domainProducts dProds) throws ClassNotFoundException, SQLException;
	public void updateOnDB(domainProducts dProds, String colName, String value) throws ClassNotFoundException, SQLException;
	public void updateOnDB(domainProducts dProds, String colName, int value) throws ClassNotFoundException, SQLException;
	public void updateQty(domainProducts dProds, String colName, int value) throws ClassNotFoundException, SQLException;
	public void deleteFromDB(domainProducts dProds) throws ClassNotFoundException, SQLException;
	public boolean ifExists(domainProducts dProds) throws ClassNotFoundException, SQLException;
	public int getQty(domainOrderDetails dOrderDetails) throws ClassNotFoundException, SQLException;
	public Connection createConnection() throws ClassNotFoundException, SQLException;
}
