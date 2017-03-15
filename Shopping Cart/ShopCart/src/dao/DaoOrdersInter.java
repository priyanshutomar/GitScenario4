package dao;

import java.sql.Connection;
import java.sql.SQLException;

import domain.domainOrders;

public interface DaoOrdersInter {
	public int getUser(int order_id) throws SQLException, ClassNotFoundException;
	public void saveToDB(domainOrders dOrders, int order_id) throws ClassNotFoundException, SQLException;
	public int ifExists(domainOrders dOrders) throws ClassNotFoundException, SQLException;
	public Connection createConnection() throws ClassNotFoundException, SQLException;
	public void updateDB(domainOrders dOrders) throws ClassNotFoundException, SQLException;
}
